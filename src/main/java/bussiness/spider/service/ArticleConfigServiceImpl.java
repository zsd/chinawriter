package bussiness.spider.service;

import bussiness.spider.ArticleModule;
import bussiness.spider.dao.ArticleConfigDao;
import bussiness.spider.domain.ArticleConfig;
import bussiness.spider.service.pipeline.TaobaoJsonPipeline;
import bussiness.spider.service.spider.TaobaoSpider;
import com.zsd.comm.exception.ServiceException;
import com.zsd.comm.orm.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.Map;

/**
 * 作家活动数据采集配置服务类.
 * @author zhousd
 */
@Service
@Transactional
public class ArticleConfigServiceImpl implements ArticleConfigService {

    private static Logger logger = LoggerFactory.getLogger(ArticleConfigServiceImpl.class);

    @Autowired
    private ArticleConfigDao articleConfigDao;

    @Override
    public ArticleConfig getById(String id) {
        try {
            return articleConfigDao.getById(id);
        } catch (Exception e) {
            logger.error("Get by id error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_GETBYID, e);
        }
    }

    @Override
    public List<ArticleConfig> getAll() {
        try {
            return articleConfigDao.getAll();
        } catch (Exception e) {
            logger.error("Get by id error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_GETBYID, e);
        }
    }

    @Override
    public void save(ArticleConfig articleConfig) {
        try {
            articleConfigDao.save(articleConfig);
        } catch (Exception e) {
            logger.error("Save error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_SAVE, e);
        }
    }

    @Override
    public void update(ArticleConfig articleConfig) {
        try {
            articleConfigDao.update(articleConfig);
        } catch (Exception e) {
            logger.error("Save error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_UPDATE, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            articleConfigDao.delete(id);
        } catch (Exception e) {
            logger.error("delete error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_DEL, e);
        }
    }

    @Override
    public Page<ArticleConfig> search(Page<ArticleConfig> page, Map<String, Object> param) {
        try {
            return articleConfigDao.search(page, param);
        } catch (Exception e) {
            logger.error("search error!", e);
            throw new ServiceException(ArticleModule.ERR_SEV_SEARCH, e);
        }
    }
}
