package cn.e3mal.item.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import cn.e3mall.manager.service.TbItemDescService;
import cn.e3mall.manager.service.TbItemService;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected FreeMarkerConfig freeMarkerConfig;

	@Autowired
	protected TbItemService tbItemService;
	@Autowired
	protected TbItemDescService tbItemDescService;
}
