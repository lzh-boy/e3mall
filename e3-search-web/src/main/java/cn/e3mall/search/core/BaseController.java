package cn.e3mall.search.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.search.service.TbItemService;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected TbItemService tbItemService;
}
