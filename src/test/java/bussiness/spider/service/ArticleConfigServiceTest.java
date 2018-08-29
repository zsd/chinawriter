package bussiness.spider.service;

import bussiness.spider.data.ArticleConfigDataProvider;
import bussiness.spider.domain.ArticleConfig;
import com.zsd.AbstractTest;
import com.zsd.comm.DataUtilsTest;
import com.zsd.comm.orm.Page;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * 作家活动数据采集配置服务测试.
 * @author zhousd
 */
public class ArticleConfigServiceTest extends AbstractTest {

    @Autowired
    private ArticleConfigService articleConfigService;

    /**
     * 测试新增.
     */
    @Test
    public void testSave() {
        ArticleConfig articleConfig = ArticleConfigDataProvider.getArticleConfig();
        articleConfigService.save(articleConfig);
    }

    /**
     * 测试获取.
     */
    @Test
    public void testGetById() {
        ArticleConfig articleConfig = articleConfigService.getById(DataUtilsTest.ID_1);
        Assert.assertNotNull(articleConfig);
    }

    /**
     * 测试获取.
     */
    @Test
    public void testGetAll() {
        List<ArticleConfig> articleConfigList = articleConfigService.getAll();
        Assert.assertNotNull(articleConfigList);
    }

    /**
     * 测试更新.
     */
    @Test
    public void testUpdate() {
        ArticleConfig articleConfig = articleConfigService.getById(DataUtilsTest.ID_1);
        articleConfig.setRemark("备注2");
        articleConfigService.update(articleConfig);
    }

    /**
     * 测试删除.
     */
    @Test
    public void testDelete() {
        articleConfigService.delete(DataUtilsTest.ID_1);
        ArticleConfig articleConfig = articleConfigService.getById(DataUtilsTest.ID_1);
        Assert.assertNull(articleConfig);
    }

    /**
     * 测试查询列表.
     */
    @Test
    public void testSearch() {
        Page<ArticleConfig> articleConfigPage = articleConfigService.search(new Page<>(), new HashMap<>());
        Assert.assertNotNull(articleConfigPage);
    }

}
