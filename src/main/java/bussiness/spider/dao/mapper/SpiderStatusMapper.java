package bussiness.spider.dao.mapper;

import bussiness.spider.domain.SpiderStatus;
import com.zsd.dic.domain.Dic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采集状态对应类.
 * @author zhousd
 */
@Repository
public interface SpiderStatusMapper {

    /**
     * 获取.
     */
    SpiderStatus get();

    /**
     * 更新.
     */
    void updateStatus(String status);
}
