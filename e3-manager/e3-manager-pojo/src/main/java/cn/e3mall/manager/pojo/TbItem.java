package cn.e3mall.manager.pojo;

import java.io.Serializable;
import java.util.Date;

import cn.e3mall.common.core.BaseEntity;

/**
 * 
 * 
 * @author colg
 */
public class TbItem extends BaseEntity implements Serializable {
	/**
	 * 商品id，同时也是商品编号
	 */
	private Long id;

	/**
	 * 商品标题
	 */
	private String title;

	/**
	 * 商品卖点
	 */
	private String sellPoint;

	/**
	 * 商品价格，单位为：分
	 */
	private Long price;

	/**
	 * 库存数量
	 */
	private Integer num;

	/**
	 * 商品条形码
	 */
	private String barcode;

	/**
	 * 商品图片
	 */
	private String image;

	/**
	 * 所属类目，叶子类目
	 */
	private Long cid;

	/**
	 * 商品状态，1-正常，2-下架，3-删除
	 */
	private Byte status;

	/**
	 * 创建时间
	 */
	private Date created;

	/**
	 * 更新时间
	 */
	private Date updated;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id - 商品id，同时也是商品编号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            商品id，同时也是商品编号
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return title - 商品标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            商品标题
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * @return sell_point - 商品卖点
	 */
	public String getSellPoint() {
		return sellPoint;
	}

	/**
	 * @param sellPoint
	 *            商品卖点
	 */
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint == null ? null : sellPoint.trim();
	}

	/**
	 * @return price - 商品价格，单位为：分
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            商品价格，单位为：分
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return num - 库存数量
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            库存数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return barcode - 商品条形码
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode
	 *            商品条形码
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode == null ? null : barcode.trim();
	}

	/**
	 * @return image - 商品图片
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            商品图片
	 */
	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	/**
	 * @return cid - 所属类目，叶子类目
	 */
	public Long getCid() {
		return cid;
	}

	/**
	 * @param cid
	 *            所属类目，叶子类目
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}

	/**
	 * @return status - 商品状态，1-正常，2-下架，3-删除
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            商品状态，1-正常，2-下架，3-删除
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @return created - 创建时间
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            创建时间
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
	 * @param updated
	 *            更新时间
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}