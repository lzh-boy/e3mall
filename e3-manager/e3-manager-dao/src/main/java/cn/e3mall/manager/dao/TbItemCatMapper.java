package cn.e3mall.manager.dao;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.manager.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    List<TbItemCat> selectAll();

    int updateByPrimaryKey(TbItemCat record);

	List<TbItemCat> selectByParentId(Long parentId);

	List<EasyUITreeNode> selectEasyUITreeNodeByParentId(Long parentId);
}