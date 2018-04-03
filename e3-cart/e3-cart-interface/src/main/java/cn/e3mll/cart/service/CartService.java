package cn.e3mll.cart.service;

import java.util.List;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.manager.pojo.TbItem;

/**
 * 
 *
 * @author colg
 */
public interface CartService {

	/**
	 * 添加商品到服务端购物车
	 * 
	 * @param userId
	 *            用户id
	 * @param itemId
	 *            商品id
	 * @param num
	 *            商品数量
	 * @return
	 */
	E3Result addCart(Long userId, Long itemId, Integer num);

	/**
	 * 合并购物车 - 将cookie中与redis中的购物车合并, 存入redis
	 *
	 * @param userId
	 *            用户id
	 * @param tbItemList
	 *            cookie购物车商品列表
	 * @return
	 */
	E3Result mergeCart(Long userId, List<TbItem> tbItemList);

	/**
	 * 获取服务端购物车列表
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	List<TbItem> getCartList(Long userId);

	/**
	 * 更新购物车商品数量
	 * 
	 * @param userId
	 * @param itemId
	 * @param num
	 * @return
	 */
	E3Result updateCartNum(Long userId, Long itemId, Integer num);

	/**
	 * 根据商品id删除购物车商品
	 * 
	 * @param userId
	 * @param itemId
	 * @return
	 */
	E3Result deleteCartItem(Long userId, Long itemId);

	/**
	 * 批量删除购物车商品
	 * 
	 * @param userId
	 * @param itemId
	 *            商品id数组: "1,2,3"
	 * @return
	 */
	E3Result deleteBathCart(Long userId, String itemId);

	/**
	 * 清空购物车
	 * 
	 * @param userId
	 * @return
	 */
	E3Result deleteAllCart(Long userId);
}
