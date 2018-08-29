package bussiness.spider.domain;

import com.zsd.comm.domain.EntityImpl;
import com.zsd.dic.domain.Dic;

import java.util.Date;

/**
 * 活动数据.
 * @author chouharry
 */
public class Article extends EntityImpl {

    private String content; // 活动内容

    private String fromUrl; // 来源链接

    private String fromWeb; // 来源网站：中国作家网等等

    private Date publishDate; // 发布日期

    private Dic isRead = new Dic("未读"); // 是否已读：未读、已读

    private Dic isFocus = new Dic("未关注"); // 是否关注：未关注、关注

    private String remark; // 备注

    public Article() {
        super();
    }

    public Article(String fromWeb) {
        this();
        this.fromWeb = fromWeb;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("title = ").append(this.getName()).append("\n")
                .append("content = ").append(this.getContent()).append("\n")
                .append("fromUrl = ").append(this.getFromUrl()).append("\n")
                .append("fromWeb = ").append(this.getFromWeb()).append("\n")
                .append("publishDate = ").append(this.getPublishDate());
        return builder.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getFromWeb() {
        return fromWeb;
    }

    public void setFromWeb(String fromWeb) {
        this.fromWeb = fromWeb;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Dic getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(Dic isFocus) {
        this.isFocus = isFocus;
    }

    public Dic getIsRead() {
        return isRead;
    }

    public void setIsRead(Dic isRead) {
        this.isRead = isRead;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }
}
