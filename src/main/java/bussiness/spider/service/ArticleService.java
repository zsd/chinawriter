package bussiness.spider.service;

import bussiness.spider.domain.Article;
import com.zsd.comm.orm.Page;

import java.util.Map;

/**
 * 作家活动采集服务接口.
 * @author zhousd
 */
public interface ArticleService {

    /**
     * 采集数据执行方法.
     */
    void spider();

    /**
     * 根据ID获取.
     */
    Article getById(String id);

    /**
     * 根据fromUrl获取.
     */
    Article getByFromUrl(String fromUrl);

    /**
     * 保存.
     */
    void save(Article article);

    /**
     * 更新.
     */
    void update(Article article);

    /**
     * 删除.
     * @param ids id列表,以逗号分开
     */
    void deleteByIds(String ids);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Article> search(Page<Article> page, Map<String, Object> param);


}
