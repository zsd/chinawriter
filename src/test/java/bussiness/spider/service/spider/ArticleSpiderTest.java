package bussiness.spider.service.spider;

import org.junit.Test;
import us.codecraft.webmagic.Spider;

/**
 * 测试中国作家网采集.
 * @author zhousd
 */
public class ArticleSpiderTest {

    @Test
    public void spider() {
        Spider.create(new ArticleSpider())
                .addUrl("http://www.chinawriter.com.cn/403982/index.html").run();
    }
}
