package bussiness.spider.dao;

import bussiness.spider.ArticleModule;
import bussiness.spider.dao.mapper.ArticleMapper;
import bussiness.spider.domain.Article;
import com.zsd.comm.exception.DataAccessException;
import com.zsd.comm.orm.Page;
import com.zsd.comm.utils.Identities;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 作家活动管理数据访问实现类.
 * @author zhousd
 */
@Repository
public class ArticleDao {

    private static Logger logger = LoggerFactory.getLogger(ArticleDao.class);

    @Autowired
    private ArticleMapper articleMapper;

    public Article getById(String id) {
        try {
            return articleMapper.getById(id);
        } catch (Exception e) {
            logger.debug("Get by id error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYID, e);
        }
    }

    public Article getByFromUrl(String fromUrl) {
        try {
            return articleMapper.getByFromUrl(fromUrl);
        } catch (Exception e) {
            logger.debug("Get by fromUrl error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYID, e);
        }
    }

    public void save(Article article) {
        try {
            if(StringUtils.isBlank(article.getId())) article.setId(Identities.uuid());
            articleMapper.save(article);
        } catch (Exception e) {
            logger.debug("Save error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYITEM, e);
        }

    }

    public void update(Article article) {
        try {
            articleMapper.update(article);
        } catch (Exception e) {
            logger.debug("Update error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_UPDATE, e);
        }
    }

    public void delete(String id) {
        try {
            articleMapper.delete(id);
        } catch (Exception e) {
            logger.debug("Delete error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_DEL, e);
        }
    }

    public Page<Article> search(Page<Article> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<Article> lists = articleMapper.search(name, skip, limit);
        long count = articleMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }
}
