package cn.e3mall.search.service;

import org.apache.solr.client.solrj.SolrQuery;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.vo.SearchResult;

/**
 * 维护索引库
 *
 * @author colg
 */
public interface TbItemService {

	/**
	 * 把所有商品导入索引库
	 * 
	 * @return
	 */
	E3Result importAllItems();

	/**
	 * 根据查询条件，对Solr服务器执行查询
	 * 
	 * @param solrQuery
	 * @return
	 */
	SearchResult search(SolrQuery solrQuery);

	/**
	 * 根据关键字，分页查询Solr服务器
	 * 
	 * @param keyword
	 * @param page
	 * @param rows
	 * @return
	 */
	SearchResult search(String keyword, Integer page, Integer rows);

	/**
	 * 根据商品id，添加索引库
	 * 
	 * @param id
	 * @return
	 */
	E3Result addDocument(Long id);

}
