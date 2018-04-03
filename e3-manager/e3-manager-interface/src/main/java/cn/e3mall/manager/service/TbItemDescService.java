package cn.e3mall.manager.service;

import cn.e3mall.manager.pojo.TbItemDesc;

/**
 * 
 *
 * @author colg
 */
public interface TbItemDescService {

	/**
	 * 根据商品id获取商品描述
	 * 
	 * @param itemId
	 * @return
	 */
	TbItemDesc findById(Long itemId);

}
