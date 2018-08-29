package bussiness.spider.service;

import bussiness.spider.data.ArticleConfigDataProvider;
import bussiness.spider.data.ArticleDataProvider;
import bussiness.spider.domain.Article;
import bussiness.spider.domain.ArticleConfig;
import com.zsd.AbstractTest;
import com.zsd.comm.DataUtilsTest;
import com.zsd.comm.orm.Page;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * 作家活动数据采集服务测试.
 * @author zhousd
 */
public class ArticleServiceTest extends AbstractTest {

    @Autowired
    private ArticleService articleService;

    /**
     * 测试新增.
     */
    @Test
    public void testSave() {
        Article article = ArticleDataProvider.getArticle();
        articleService.save(article);
    }

    /**
     * 测试获取.
     */
    @Test
    public void testGetById() {
        Article article = articleService.getById(DataUtilsTest.ID_1);
        Assert.assertNotNull(article);
    }

    /**
     * 测试更新.
     */
    @Test
    public void testUpdate() {
        Article article = articleService.getById(DataUtilsTest.ID_1);
        article.setRemark("备注2");
        articleService.update(article);
    }

    /**
     * 测试删除.
     */
    @Test
    public void testDelete() {
        articleService.delete(DataUtilsTest.ID_1);
    }

    /**
     * 测试查询列表.
     */
    @Test
    public void testSearch() {
        Page<Article> articlePage = articleService.search(new Page<>(), new HashMap<>());
        Assert.assertNotNull(articlePage);
    }

    @Test
    public void testSpider() {
        articleService.spider();
    }

}
