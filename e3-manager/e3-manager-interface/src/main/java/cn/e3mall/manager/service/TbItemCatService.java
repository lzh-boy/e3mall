package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

/**
 * 
 *
 * @author colg
 */
public interface TbItemCatService {

	List<EasyUITreeNode> getItemCatList(Long parentId);
	
}
