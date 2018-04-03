package cn.e3mall.order.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.manager.pojo.TbItem;
import cn.e3mall.manager.pojo.TbUser;
import cn.e3mall.order.core.BaseController;
import cn.e3mll.order.pojo.OrderInfo;

/**
 * 订单管理Controller
 *
 * @author colg
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	/**
	 * 展示订单结算页面
	 * 
	 * @param tbUser
	 *            注解@RequestAttribute可以被用于访问由过滤器或拦截器创建的、预先存在的请求属性
	 * @return
	 */
	@GetMapping("/order-cart")
	public String showOrderCart(@RequestAttribute(value = "user") TbUser tbUser, Model model) {
		// 取用户id
		Long userId = tbUser.getId();
		List<TbItem> cartList = cartService.getCartList(userId);

		// 根据用户id取收货地址
		// 根据用户id取支付方式列表

		// 把购物车列表传递给jsp
		model.addAttribute("cartList", cartList);
		// 返回逻辑视图
		return "order-cart";
	}

	/**
	 * 提交订单
	 * 
	 * @param tbUser
	 *            request里取得tbUser
	 * @param payment
	 *            传值给request
	 * @param orderInfo
	 *            订单信息
	 * @return
	 */
	@PostMapping("/create")
	public String createOrderInfo(@RequestAttribute(value = "user") TbUser tbUser, Model model, OrderInfo orderInfo) {
		// 生成订单
		E3Result e3Result = orderService.createOrder(orderInfo, tbUser);
		model.addAttribute("orderId", e3Result.getData());
		model.addAttribute("payment", orderInfo.getPayment());

		// 清空当前用户的购物车
		cartService.deleteAllCart(tbUser.getId());

		// 返回结算成功页面
		return "success";
	}
}
