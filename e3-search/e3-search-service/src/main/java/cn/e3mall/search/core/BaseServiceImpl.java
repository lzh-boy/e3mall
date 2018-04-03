package cn.e3mall.search.core;

import org.apache.solr.client.solrj.SolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.search.dao.TbItemMapper;

/**
 * ServiceImpl层基础类，用于抽取注入的Mapper
 *
 * @author colg
 */
public abstract class BaseServiceImpl {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	protected SolrServer solrServer;

	@Autowired
	protected TbItemMapper tbItemMapper;
}
