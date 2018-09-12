package bussiness.spider.domain;

import com.zsd.comm.domain.EntityImpl;
import com.zsd.dic.domain.Dic;

/**
 * 爬虫状态.
 * @author harry
 */
public class SpiderStatus extends EntityImpl {

    private String status; // 状态：未执行、执行中

    public static final String STATUS_NOEXE = "未执行";
    public static final String STATUS_EXEING = "执行中";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
