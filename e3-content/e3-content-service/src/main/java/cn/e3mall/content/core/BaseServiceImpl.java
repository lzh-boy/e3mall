package cn.e3mall.content.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.manager.dao.*;

/**
 * ServiceImpl层基础类，用于抽取注入的Mapper
 *
 * @author colg
 */
public abstract class BaseServiceImpl {

	@Autowired
	protected JedisClient jedisClient;
	
	@Autowired
	protected TbContentCategoryMapper tbContentCategoryMapper;
	@Autowired
	protected TbContentMapper tbContentMapper;
}
