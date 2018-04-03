package cn.e3mall.manager.pojo;

import java.io.Serializable;
import java.util.Date;

import cn.e3mall.common.core.BaseEntity;

/**
 * 
 * 
 * @author colg
 */
public class TbItemDesc extends BaseEntity implements Serializable {
    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 商品描述
     */
    private String itemDesc;

    private static final long serialVersionUID = 1L;

    /**
     * @return item_id - 商品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId 商品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
     * @return item_desc - 商品描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc 商品描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}