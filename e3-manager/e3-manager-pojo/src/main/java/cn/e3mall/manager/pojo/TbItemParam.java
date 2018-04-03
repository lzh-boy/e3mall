package cn.e3mall.manager.pojo;

import java.io.Serializable;
import java.util.Date;

import cn.e3mall.common.core.BaseEntity;

/**
 * 
 * 
 * @author colg
 */
public class TbItemParam extends BaseEntity implements Serializable {
    /**
     * 商品规格参数ID
     */
    private Long id;

    /**
     * 商品类目ID
     */
    private Long itemCatId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 参数数据，格式为json格式
     */
    private String paramData;

    private static final long serialVersionUID = 1L;

    /**
     * @return id - 商品规格参数ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 商品规格参数ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return item_cat_id - 商品类目ID
     */
    public Long getItemCatId() {
        return itemCatId;
    }

    /**
     * @param itemCatId 商品类目ID
     */
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
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
     * @return param_data - 参数数据，格式为json格式
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * @param paramData 参数数据，格式为json格式
     */
    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}