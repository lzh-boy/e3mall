package cn.e3mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 页面跳转Controller
 *
 * @author colg
 */
@Controller
public class PageController {

	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
}
