package bussiness.spider.service;

import bussiness.spider.ArticleModule;
import bussiness.spider.dao.ArticleDao;
import bussiness.spider.domain.Article;
import bussiness.spider.domain.ArticleConfig;
import bussiness.spider.service.pipeline.TaobaoJsonPipeline;
import bussiness.spider.service.spider.ArticleSpider;
import bussiness.spider.service.spider.TaobaoSpider;
import com.zsd.comm.exception.ServiceException;
import com.zsd.comm.orm.Page;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.Map;

/**
 * 作家活动数据采集服务类.
 * @author zhousd
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleConfigService articleConfigService;

    @Override
    public void spider() {
        //1、查出配置
        List<ArticleConfig> articleConfigList = articleConfigService.getAll();
        //2、根据配置，启动爬虫
        if (CollectionUtils.isEmpty(articleConfigList)) return;
        for (ArticleConfig articleConfig : articleConfigList) {
            Spider.create(new ArticleSpider(articleConfig, articleDao)).addUrl(articleConfig.getListUrl()).thread(5).run();
        }
    }

    @Override
    public Article getById(String id) {
        try {
            return articleDao.getById(id);
        } catch (Exception e) {
            logger.error("Get by id error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_GETBYID, e);
        }
    }

    @Override
    public Article getByFromUrl(String fromUrl) {
        try {
            return articleDao.getByFromUrl(fromUrl);
        } catch (Exception e) {
            logger.error("Get by id error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_GETBYID, e);
        }
    }

    @Override
    public void save(Article article) {
        try {
            articleDao.save(article);
        } catch (Exception e) {
            logger.error("Save article error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_SAVE, e);
        }
    }

    @Override
    public void update(Article article) {
        try {
            articleDao.update(article);
        } catch (Exception e) {
            logger.error("Save article error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_SAVE, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            articleDao.delete(id);
        } catch (Exception e) {
            logger.error("delete error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_DEL, e);
        }
    }

    @Override
    public Page<Article> search(Page<Article> page, Map<String, Object> param) {
        try {
            return articleDao.search(page, param);
        } catch (Exception e) {
            logger.error("Search error!", e);
            throw new ServiceException(e);
        }
    }
}
