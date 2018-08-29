package bussiness.spider.domain;

import com.zsd.comm.domain.EntityImpl;

public class ArticleConfig extends EntityImpl {

    private String fromWeb; // 来源网址

    private String listUrl; // 列表链接,活动列表页面

    private String articleUrl; // 文章链接,活动列表页面

    private String namePath; // 标题路径

    private String contentPath; // 内容路径

    private String publishDatePath; // 发布日期路径

    private String publishDateFormat; // 日期格式
    
    private String remark; // 备注

    public String getFromWeb() {
        return fromWeb;
    }

    public void setFromWeb(String fromWeb) {
        this.fromWeb = fromWeb;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getPublishDatePath() {
        return publishDatePath;
    }

    public void setPublishDatePath(String publishDatePath) {
        this.publishDatePath = publishDatePath;
    }

    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPublishDateFormat() {
        return publishDateFormat;
    }

    public void setPublishDateFormat(String publishDateFormat) {
        this.publishDateFormat = publishDateFormat;
    }
}
