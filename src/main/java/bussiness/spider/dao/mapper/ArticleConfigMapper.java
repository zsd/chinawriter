package bussiness.spider.dao.mapper;

import bussiness.spider.domain.ArticleConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作家活动配置数据对应类.
 * @author zhousd
 */
@Repository
public interface ArticleConfigMapper {

    /**
     * 根据主键获取.
     */
    ArticleConfig getById(String id);

    /**
     * 保存.
     */
    void save(ArticleConfig articleConfig);

    /**
     * 更新.
     */
    void update(ArticleConfig articleConfig);

    /**
     * 根据ID删除.
     */
    void delete(String id);

    /**
     * 查询列表.
     */
    List<ArticleConfig> search(@Param(value = "name") String name,
                               @Param(value = "skip") int skip,
                               @Param(value = "limit") int limit);

    /**
     * 查询列表数量.
     */
    long count(String name);

    /**
     * 获取全部配置.
     */
    List<ArticleConfig> getAll();
}
