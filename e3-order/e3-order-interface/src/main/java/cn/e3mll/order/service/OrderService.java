package cn.e3mll.order.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.manager.pojo.TbUser;
import cn.e3mll.order.pojo.OrderInfo;

/**
 * 
 *
 * @author colg
 */
public interface OrderService {

	/**
	 * 生成订单
	 * 
	 * @param orderInfo
	 *            订单信息
	 * @param tbUser
	 *            当前登录用户
	 * @return
	 */
	E3Result createOrder(OrderInfo orderInfo, TbUser tbUser);
}
