package cn.e3mall.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.manager.core.BaseServiceImpl;
import cn.e3mall.manager.service.TbItemCatService;

/**
 * 
 *
 * @author colg
 */
@Service
public class TbItemCatServiceImpl extends BaseServiceImpl implements TbItemCatService {

	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
/*		// 根据parentId查询子节点列表
		List<TbItemCat> list = tbItemCatMapper.selectByParentId(parentId);
		// 把列表转换成EasyUiTreeNode列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode(tbItemCat.getId(), tbItemCat.getName(), tbItemCat.getIsParent() ? "closed" : "open");
			// 添加到结果列表
			resultList.add(node);
		}
		// 返回结果
		return resultList;*/
		
		
		// 通过Sql直接把结果封装到 List<EasyUITreeNode>
		return tbItemCatMapper.selectEasyUITreeNodeByParentId(parentId);
	}

}
