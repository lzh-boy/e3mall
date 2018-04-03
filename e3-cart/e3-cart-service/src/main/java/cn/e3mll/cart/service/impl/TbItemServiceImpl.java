package cn.e3mll.cart.service.impl;

import org.springframework.stereotype.Service;

import cn.e3mall.manager.pojo.TbItem;
import cn.e3mll.cart.core.BaseServiceImpl;
import cn.e3mll.cart.service.TbItemService;

/**
 * 
 *
 * @author colg
 */
@Service
public class TbItemServiceImpl extends BaseServiceImpl implements TbItemService {

	@Override
	public TbItem getTbItemById(Long id) {
		return tbItemMapper.selectByPrimaryKey(id);
	}

}
