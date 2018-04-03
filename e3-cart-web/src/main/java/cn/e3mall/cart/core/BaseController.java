package cn.e3mall.cart.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mll.cart.service.*;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected TbItemService tbItemService;
	@Autowired
	protected CartService cartService;
}
