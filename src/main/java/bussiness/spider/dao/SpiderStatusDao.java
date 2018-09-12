package bussiness.spider.dao;

import bussiness.spider.ArticleModule;
import bussiness.spider.dao.mapper.ArticleMapper;
import bussiness.spider.dao.mapper.SpiderStatusMapper;
import bussiness.spider.domain.Article;
import bussiness.spider.domain.SpiderStatus;
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
 * 采集状态数据访问实现类.
 * @author zhousd
 */
@Repository
public class SpiderStatusDao {

    private static Logger logger = LoggerFactory.getLogger(SpiderStatusDao.class);

    @Autowired
    private SpiderStatusMapper spiderStatusMapper;

    public SpiderStatus get() {
        try {
            return spiderStatusMapper.get();
        } catch (Exception e) {
            logger.debug("Get by id error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_GETBYID, e);
        }
    }

    public void updateStatus(String status) {
        try {
            spiderStatusMapper.updateStatus(status);
        } catch (Exception e) {
            logger.debug("Update error!", e);
            throw new DataAccessException(ArticleModule.ERR_DAO_UPDATE, e);
        }
    }
}
