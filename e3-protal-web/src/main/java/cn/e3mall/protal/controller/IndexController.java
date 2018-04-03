package cn.e3mall.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.e3mall.manager.pojo.TbContent;
import cn.e3mall.protal.core.BaseController;

/**
 * 首页展示
 *
 * @author colg
 */
@Controller
public class IndexController extends BaseController {

	/** 大广告 */
	@Value("${CONTENT_CAROUSEL_ID}")
	private Long CONTENT_CAROUSEL_ID;
	
	/** 小广告 */
	@Value("${CONTENT_SMALL_ID}")
	private Long CONTENT_SMALL_ID;
	
	/** 搜索框 */
	@Value("${CONTENT_SEARCH_ID}")
	private Long CONTENT_SEARCH_ID;

	/**
	 * 首页 </br>
	 * http://localhost:8082/ 在spirngmvc里没有找到对应页面，会去web.xml里找 index.html
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String showIndex(Model model) {
		// 查询大广告
		List<TbContent> ad1List = tbContentService.getContentListByCategoryId(CONTENT_CAROUSEL_ID);// 大广告 89
		// 把结果传递给页面
		model.addAttribute("ad1List", ad1List);
		
		// 查询小广告
		List<TbContent> ad2List = tbContentService.getContentListByCategoryId(CONTENT_SMALL_ID);// 小广告 90
		model.addAttribute("ad2List", ad2List);
		
		// 查询搜索框下面广告
		List<TbContent> ad3List = tbContentService.getContentListByCategoryId(CONTENT_SEARCH_ID); // 搜索框 101
		model.addAttribute("ad3List", ad3List);
		
		// 购物车数量
		// TODO colg 购物车数量
		return "index";
	}
}
