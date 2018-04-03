package cn.e3mall.manager.core;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.manager.dao.*;

/**
 * ServiceImpl层基础类，用于抽取注入的Mapper
 *
 * @author colg
 */
public abstract class BaseServiceImpl {

	@Autowired
	protected JmsTemplate jmsTemplate;
	/** 如果有id，根据id注入，如果没有id，在根据类型注入 */
	@Resource
	protected Destination topicDestination;
	@Autowired
	protected JedisClient jedisClient;

	@Autowired
	protected TbItemMapper tbItemMapper;
	@Autowired
	protected TbItemCatMapper tbItemCatMapper;
	@Autowired
	protected TbItemDescMapper tbItemDescMapper;
	@Autowired
	protected TbContentCategoryMapper tbContentCategoryMapper;
	@Autowired
	protected TbContentMapper tbContentMapper;
}
