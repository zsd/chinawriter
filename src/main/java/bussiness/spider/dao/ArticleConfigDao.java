package bussiness.spider.dao;

import bussiness.spider.ArticleModule;
import bussiness.spider.dao.mapper.ArticleConfigMapper;
import bussiness.spider.dao.mapper.ArticleMapper;
import bussiness.spider.domain.ArticleConfig;
import com.zsd.comm.exception.DataAccessException;
import com.zsd.comm.orm.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 作家活动配置管理数据访问实现类.
 * @author zhousd
 */
@Repository
public class ArticleConfigDao {

    private static Logger logger = LoggerFactory.getLogger(ArticleConfigDao.class);

    @Autowired
    private ArticleConfigMapper articleConfigMapper;

    public ArticleConfig getById(String id) {
        try {
            return articleConfigMapper.getById(id);
        } catch (Exception e) {
            logger.debug("Get by id error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYID, e);
        }
    }

    public void save(ArticleConfig articleConfig) {
        try {
            articleConfigMapper.save(articleConfig);
        } catch (Exception e) {
            logger.debug("Save error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYITEM, e);
        }

    }

    public void update(ArticleConfig articleConfig) {
        try {
            articleConfigMapper.update(articleConfig);
        } catch (Exception e) {
            logger.debug("Update error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_UPDATE, e);
        }
    }

    public void delete(String id) {
        try {
            articleConfigMapper.delete(id);
        } catch (Exception e) {
            logger.debug("Delete error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_DEL, e);
        }
    }

    public Page<ArticleConfig> search(Page<ArticleConfig> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<ArticleConfig> lists = articleConfigMapper.search(name, skip, limit);
        long count = articleConfigMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }

    public List<ArticleConfig> getAll() {
        return articleConfigMapper.getAll();
    }
}
