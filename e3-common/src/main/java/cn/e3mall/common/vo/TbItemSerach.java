package cn.e3mall.common.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import cn.e3mall.common.core.BaseEntity;

/**
 * 商品信息 - 全文检索
 *
 * @author colg
 */
public class TbItemSerach extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String sellPoint;
	private Long price;
	private String image;
	private String categoryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 获取图片集合
	 * 
	 * @return
	 */
	public String[] getImages() {
		return StringUtils.split(this.image, ",");
	}

}
