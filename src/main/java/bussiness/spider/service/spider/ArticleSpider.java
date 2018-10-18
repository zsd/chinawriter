package bussiness.spider.service.spider;

import bussiness.spider.dao.ArticleDao;
import bussiness.spider.domain.Article;
import bussiness.spider.domain.ArticleConfig;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 淘宝爬虫.
 * @author zhousd
 */
public class ArticleSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    private ArticleDao articleDao;

    private ArticleConfig articleConfig;

    private static Logger logger = LoggerFactory.getLogger(ArticleSpider.class);

    public ArticleSpider() {
        super();
    }

    public ArticleSpider(ArticleConfig articleConfig, ArticleDao articleDao) {
        this();
        this.articleConfig = articleConfig;
        this.articleDao = articleDao;
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(articleConfig.getListUrl()).match()) { //列表页
            page.addTargetRequests(page.getHtml().links().regex(articleConfig.getArticleUrl()).all());
        } else { // 文章页面
            Article article = new Article(articleConfig.getFromWeb());
            String fromUrl = page.getUrl().toString();
            article.setName(page.getHtml().xpath(articleConfig.getNamePath()).toString());
            Article articleData = articleDao.getByFromUrl(fromUrl);
            if (StringUtils.isBlank(article.getName()) || articleData != null) { // 如果没有标题,或者已经存在此内容，就跳过
                page.setSkip(true);
            } else {
                // 处理发布日期
                Date publishDate = null;
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(articleConfig.getPublishDateFormat());
                    publishDate = simpleDateFormat.parse(page.getHtml().xpath(articleConfig.getPublishDatePath()).toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                article.setFromUrl(fromUrl);
                article.setPublishDate(publishDate);
                article.setContent(page.getHtml().xpath(articleConfig.getContentPath()).toString());
                article.setRemark(articleConfig.getRemark());
                logger.debug(article.toString());
                this.articleDao.save(article);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
