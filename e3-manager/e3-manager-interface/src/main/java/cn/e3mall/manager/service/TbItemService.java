package cn.e3mall.manager.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.manager.pojo.TbItem;

/**
 * 
 *
 * @author colg
 */
public interface TbItemService {

	/**
	 * 根据商品id获取商品
	 * 
	 * @param id
	 * @return
	 */
	TbItem getTbItemById(Long id);

	/**
	 * 分页查询商品列表
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGridResult getItemList(Integer page, Integer rows);

	/**
	 * 添加商品
	 * 
	 * @param tbItem
	 * @param desc
	 * @return
	 */
	E3Result addItem(TbItem tbItem, String desc);

	/**
	 * 修改商品
	 * 
	 * @param id
	 * @param tbItem
	 * @param desc
	 * @return
	 */
	E3Result updateItem(Long id, TbItem tbItem, String desc);

	/**
	 * 批量删除商品
	 * 
	 * @param ids
	 * @return
	 */
	E3Result delete(String ids);

	/**
	 * 批量下架商品
	 * 
	 * @param ids
	 * @return
	 */
	E3Result updateInstock(String ids);

	/**
	 * 批量上架商品
	 * 
	 * @param ids
	 * @return
	 */
	E3Result updateReshelf(String ids);

}
