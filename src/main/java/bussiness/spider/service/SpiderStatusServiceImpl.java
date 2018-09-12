package bussiness.spider.service;

import bussiness.spider.dao.SpiderStatusDao;
import bussiness.spider.domain.SpiderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作家活动数据采集服务类.
 * @author zhousd
 */
@Service
@Transactional
public class SpiderStatusServiceImpl implements SpiderStatusService {

    private static Logger logger = LoggerFactory.getLogger(SpiderStatusServiceImpl.class);

    @Autowired
    private SpiderStatusDao spiderStatusDao;

    @Override
    public SpiderStatus get() {
        return spiderStatusDao.get();
    }

    @Override
    public void updateStatus(String status) {
        spiderStatusDao.updateStatus(status);
    }
}
