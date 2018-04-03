package cn.e3mall.protal.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.content.service.*;
import cn.e3mll.cart.service.*;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected TbContentService tbContentService;
	@Autowired
	protected TbItemService tbItemService;
}
