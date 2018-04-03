package cn.e3mall.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.manager.core.BaseController;
import cn.e3mall.manager.pojo.TbItemDesc;

/**
 * 
 *
 * @author colg
 */
@RestController
@RequestMapping("/tb/item/desc")
public class TbItemDescController extends BaseController {

	/**
	 * 根据商品id获取描述信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public E3Result findById(@PathVariable("id") Long itemId) {
		TbItemDesc tbItemDesc = tbItemDescService.findById(itemId);
		return E3Result.ok(tbItemDesc);
	}
}