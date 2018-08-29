package bussiness.spider.service;

import bussiness.spider.domain.ArticleConfig;
import com.zsd.comm.orm.Page;

import java.util.List;
import java.util.Map;

/**
 * 作家活动采集配置服务接口.
 * @author zhousd
 */
public interface ArticleConfigService {

    /**
     * 根据ID获取.
     */
    ArticleConfig getById(String id);

    /**
     * 获取全部.
     */
    List<ArticleConfig> getAll();

    /**
     * 保存.
     */
    void save(ArticleConfig articleConfig);

    /**
     * 更新.
     */
    void update(ArticleConfig articleConfig);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<ArticleConfig> search(Page<ArticleConfig> page, Map<String, Object> param);
}
