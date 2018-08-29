package bussiness.spider.data;

import bussiness.spider.domain.ArticleConfig;
import com.zsd.comm.DataUtilsTest;

/**
 * 作家活动采集配置数据提供类.
 * @author zhousd
 */
public final class ArticleConfigDataProvider {

    /**
     * 生成实体.
     */
    public static ArticleConfig getArticleConfig() {
        ArticleConfig obj = new ArticleConfig();
        obj.setId(DataUtilsTest.ID_1);
        obj.setFromWeb("中国作家网");
        obj.setListUrl("http://www.chinawriter.com.cn/403982/index.html");
        obj.setArticleUrl("(http://www.chinawriter.com.cn/n1/([0-9]*)/([0-9]*)/c[0-9]*-[0-9]*.html)");
        obj.setNamePath("//div[@class='list_warp']/h6/em/text()");
        obj.setPublishDatePath("//div[@class='end_info']/p/em/text()");
        obj.setContentPath("//div[@class='end_article']//p//text()");
        obj.setPublishDateFormat("yyyy年MM月dd日HH:mm");
        obj.setRemark("备注");
        return obj;
    }

    private ArticleConfigDataProvider() {}

}
