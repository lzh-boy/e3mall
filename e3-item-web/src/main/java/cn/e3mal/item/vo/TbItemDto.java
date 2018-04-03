package cn.e3mal.item.vo;

import org.apache.commons.lang3.StringUtils;

import cn.e3mall.manager.pojo.TbItem;

/**
 * 扩展 tbItem对象
 *
 * @author colg
 */
public class TbItemDto extends TbItem {

	private static final long serialVersionUID = 1L;

	public TbItemDto(TbItem tbItem) {
		this.setId(tbItem.getId());
		this.setTitle(tbItem.getTitle());
		this.setSellPoint(tbItem.getSellPoint());
		this.setPrice(tbItem.getPrice());
		this.setNum(tbItem.getNum());
		this.setBarcode(tbItem.getBarcode());
		this.setImage(tbItem.getImage());
		this.setCid(tbItem.getCid());
		this.setStatus(tbItem.getStatus());
		this.setCreated(tbItem.getCreated());
		this.setUpdated(tbItem.getUpdated());
	}

	/**
	 * 商品图片
	 * 
	 * @return
	 */
	public String[] getImages() {
		return StringUtils.split(this.getImage(), ",");
	}

}
