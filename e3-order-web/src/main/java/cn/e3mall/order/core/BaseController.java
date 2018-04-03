package cn.e3mall.order.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mll.cart.service.*;
import cn.e3mll.order.service.*;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected CartService cartService;
	@Autowired
	protected OrderService orderService;
}
