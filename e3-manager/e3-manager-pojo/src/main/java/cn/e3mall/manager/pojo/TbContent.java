package cn.e3mall.manager.pojo;

import java.io.Serializable;
import java.util.Date;

import cn.e3mall.common.core.BaseEntity;

/**
 * 
 * 
 * @author colg
 */
public class TbContent extends BaseEntity implements Serializable {
    /**
     * 内容表ID
     */
    private Long id;

    /**
     * 内容类目ID
     */
    private Long categoryId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 标题描述
     */
    private String titleDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 图片2
     */
    private String pic2;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * @return id - 内容表ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 内容表ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return category_id - 内容类目ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId 内容类目ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return title - 内容标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 内容标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return sub_title - 子标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param subTitle 子标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * @return title_desc - 标题描述
     */
    public String getTitleDesc() {
        return titleDesc;
    }

    /**
     * @param titleDesc 标题描述
     */
    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc == null ? null : titleDesc.trim();
    }

    /**
     * @return url - 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url 链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return pic - 图片绝对路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic 图片绝对路径
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * @return pic2 - 图片2
     */
    public String getPic2() {
        return pic2;
    }

    /**
     * @param pic2 图片2
     */
    public void setPic2(String pic2) {
        this.pic2 = pic2 == null ? null : pic2.trim();
    }

    /**
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}