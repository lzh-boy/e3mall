package cn.e3mll.cart.service;

import cn.e3mall.manager.pojo.TbItem;

/**
 * 
 *
 * @author colg
 */
public interface TbItemService {

	/**
	 * 根据商品id获取商品
	 * 
	 * @param id
	 * @return
	 */
	TbItem getTbItemById(Long id);

}
