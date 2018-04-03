package cn.e3mal.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mal.item.core.BaseController;
import cn.e3mal.item.vo.TbItemDto;
import cn.e3mall.manager.pojo.TbItem;
import cn.e3mall.manager.pojo.TbItemDesc;

/**
 * 商品详情页面展示Colntroller
 *
 * @author colg
 */
@Controller
@RequestMapping("/item")
public class TbItemController extends BaseController {

	/**
	 * 根据商品id获取商品详情并返回页面
	 * 
	 */
	@GetMapping("/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		// 调用服务取商品基本信息
		TbItem tbItem = tbItemService.getTbItemById(itemId);
		// 把TbItem转换成Item对象
		// BeanUtils.copyProperties(tbItem, tbItemDto);// 性能较慢
		TbItemDto tbItemDto = new TbItemDto(tbItem);
		// 取商品描述信息
		TbItemDesc tbItemDesc = tbItemDescService.findById(itemId);
		// 把信息传递给页面
		model.addAttribute("item", tbItemDto);
		model.addAttribute("itemDesc", tbItemDesc);
		// 返回逻辑视图
		return "item";
	}
}
