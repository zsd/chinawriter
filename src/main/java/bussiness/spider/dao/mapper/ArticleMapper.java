package bussiness.spider.dao.mapper;

import bussiness.spider.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作家活动数据对应类.
 * @author zhousd
 */
@Repository
public interface ArticleMapper {

    /**
     * 根据主键获取.
     */
    Article getById(String id);

    /**
     * 保存.
     */
    void save(Article article);

    /**
     * 更新.
     */
    void update(Article article);

    /**
     * 根据ID删除.
     */
    void delete(String id);

    /**
     * 查询分页列表.
     */
    List<Article> search(@Param(value = "name") String name,
                         @Param(value = "skip") int skip,
                         @Param(value = "limit") int limit);

    /**
     * 查询分页列表数量.
     */
    long count(String name);
}
