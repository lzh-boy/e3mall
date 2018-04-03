package cn.e3mall.manager.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.content.service.*;
import cn.e3mall.manager.service.*;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected TbItemService tbItemService;
	@Autowired
	protected TbItemCatService tbItemCatService;
	@Autowired
	protected TbItemDescService tbItemDescService;
	@Autowired
	protected TbContentCategoryService tbContentCategoryService;
	@Autowired
	protected TbContentService tbContentService;
	@Autowired
	protected cn.e3mall.search.service.TbItemService tbItemServiceSearch;
}
