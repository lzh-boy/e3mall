package cn.e3mall.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.manager.core.BaseController;
import cn.e3mall.manager.pojo.TbContent;

/**
 * 内容管理Controller
 *
 * @author colg
 */
@RestController
@RequestMapping("/tb/content")
public class TbContentController extends BaseController {

	/**
	 * 根据内容类目ID查询内容列表
	 * 
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/query/list")
	public EasyUIDataGridResult queryListByCategoryId(Long categoryId, Integer page, Integer rows) {
		return tbContentService.queryListByCategoryId(categoryId, page, rows);
	}

	/**
	 * 新增内容
	 * 
	 * @param tbContent
	 * @return
	 */
	@PostMapping("/save")
	public E3Result saveContent(TbContent tbContent) {
		return tbContentService.saveContent(tbContent);
	}

	/**
	 * 修改内容
	 * 
	 * @param id
	 * @param tbContent
	 * @return
	 */
	@PostMapping("/edit")
	public E3Result editContent(Long id, TbContent tbContent) {
		return tbContentService.editContent(id, tbContent);
	}

	/**
	 * 批量删除内容
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("/delete")
	public E3Result deleteContent(String ids) {
		return tbContentService.deleteContent(ids);
	}

}