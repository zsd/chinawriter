package bussiness.spider.data;

import bussiness.spider.domain.Article;
import com.zsd.comm.DataUtilsTest;
import com.zsd.dic.domain.Dic;

import java.util.Date;

/**
 * 作家活动采集数据提供类.
 * @author zhousd
 */
public final class ArticleDataProvider {

    public static final String FROM_URL = "测试来源链接";

    /**
     * 生成实体.
     */
    public static Article getArticle() {
        Article obj = new Article();
        obj.setId(DataUtilsTest.ID_1);
        obj.setName("测试标题");
        obj.setFromWeb("中国作家网");
        obj.setFromUrl(FROM_URL);
        obj.setPublishDate(new Date());
        obj.setIsRead(new Dic("未读"));
        obj.setIsFocus(new Dic("已关注"));
        return obj;
    }

    private ArticleDataProvider() {}

}
