package cn.e3mall.manager.pojo;

import java.io.Serializable;

import cn.e3mall.common.core.BaseEntity;

/**
 * 
 * 
 * @author colg
 */
public class TbOrderItem extends BaseEntity implements Serializable {
    /**
     * 订单明细ID
     */
    private String id;

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品购买数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 商品总金额
     */
    private Long totalFee;

    /**
     * 商品图片地址
     */
    private String picPath;

    private static final long serialVersionUID = 1L;

    /**
     * @return id - 订单明细ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 订单明细ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return item_id - 商品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId 商品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return num - 商品购买数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num 商品购买数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return title - 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 商品标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return price - 商品单价
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price 商品单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return total_fee - 商品总金额
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee 商品总金额
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return pic_path - 商品图片地址
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * @param picPath 商品图片地址
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}