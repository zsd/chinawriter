package bussiness.spider.service;

import bussiness.spider.domain.SpiderStatus;

import java.util.Map;

/**
 * 采集状态服务接口.
 * @author zhousd
 */
public interface SpiderStatusService {

    /**
     * 获取.
     */
    SpiderStatus get();

    /**
     * 更新.
     */
    void updateStatus(String status);
}
