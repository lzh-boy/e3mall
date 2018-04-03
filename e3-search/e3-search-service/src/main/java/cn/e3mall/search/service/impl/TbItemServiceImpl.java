package cn.e3mall.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.ListUtil;
import cn.e3mall.common.vo.SearchResult;
import cn.e3mall.common.vo.TbItemSerach;
import cn.e3mall.search.core.BaseServiceImpl;
import cn.e3mall.search.service.TbItemService;

/**
 * 
 *
 * @author colg
 */
@Service
public class TbItemServiceImpl extends BaseServiceImpl implements TbItemService {

	@Override
	public E3Result importAllItems() {
		try {
			// 查询所有商品列表
			List<TbItemSerach> list = tbItemMapper.getItemList();
			// 遍历商品列表
			for (TbItemSerach serach : list) {
				// 创建文档对象
				SolrInputDocument doc = new SolrInputDocument();
				// 向文档对象中添加域
				doc.addField("id", serach.getId());
				doc.addField("item_title", serach.getTitle());
				doc.addField("item_sell_point", serach.getSellPoint());
				doc.addField("item_price", serach.getPrice());
				doc.addField("item_image", serach.getImage());
				doc.addField("item_category_name", serach.getCategoryName());
				// 把文档对象写入索引库
				solrServer.add(doc);
			}
			// 提交
			solrServer.commit();
			// 返回导入成功
			return E3Result.ok();
		} catch (SolrServerException e) {
			e.printStackTrace();
			return E3Result.fail(500, "SolrServer 通信/解析异常！");
		} catch (IOException e) {
			e.printStackTrace();
			return E3Result.fail(500, "SolrServer I/O异常！");
		}
	}

	@Override
	public SearchResult search(SolrQuery solrQuery) {
		// 根据solrQuery查询索引库
		QueryResponse query = null;
		try {
			query = solrServer.query(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
			LOGGER.error("SolrServer 通信/解析异常！");
		}

		// 取查询结果
		SolrDocumentList results = query.getResults();

		// 取查询结果总记录数
		long recourdCount = results.getNumFound();

		// 取得商品列表，需要取高亮显示
		Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
		List<TbItemSerach> itemList = new ArrayList<>();
		for (SolrDocument doc : results) {
			TbItemSerach itemSerach = new TbItemSerach();
			itemSerach.setId((String) doc.get("id"));
			itemSerach.setSellPoint((String) doc.get("item_sell_point"));
			itemSerach.setPrice((Long) doc.get("item_price"));
			itemSerach.setImage((String) doc.get("item_image"));
			itemSerach.setCategoryName((String) doc.get("item_category_name"));
			// 取高亮显示
			List<String> list = highlighting.get(doc.get("id")).get("item_title");
			String title;
			if (ListUtil.isNotEmpty(list)) {
				title = list.get(0);
			} else {
				title = (String) doc.get("item_title");
			}
			itemSerach.setTitle(title);
			// 添加到商品列表
			itemList.add(itemSerach);
		}

		// 封装到SearchResult
		SearchResult searchResult = new SearchResult();
		searchResult.setRecourdCount(recourdCount);
		searchResult.setItemSerachs(itemList);
		// 返回结果
		return searchResult;
	}

	@Override
	public SearchResult search(String keyword, Integer page, Integer rows) {
		// 创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		// 设置查询条件
		query.setQuery(keyword);
		// 设置分页条件
		Integer start = ((page <= 0 ? 1 : page) - 1) * rows;
		query.setStart(start).setRows(rows);
		// 设置默认搜索域
		query.set("df", "item_title");
		// 开启高亮显示
		query.addHighlightField("item_title").setHighlightSimplePre("<em style=\"color: red;\">").setHighlightSimplePost("</em>");
		// 执行查询
		SearchResult searchResult = this.search(query);
		// 计算总页数
		Long recourdCount = searchResult.getRecourdCount();
		Integer totalPages = (int) ((recourdCount + rows - 1) / rows);
		searchResult.setTotalPages(totalPages);
		// 返回结果
		return searchResult;
	}

	@Override
	public E3Result addDocument(Long id) {
		// 根据商品id查询商品信息
		TbItemSerach serach = tbItemMapper.getItemById(id);
		if (serach != null) {
			// 创建一个文档对象
			SolrInputDocument doc = new SolrInputDocument();
			// 向文档对象中添加域
			doc.addField("id", serach.getId());
			doc.addField("item_title", serach.getTitle());
			doc.addField("item_sell_point", serach.getSellPoint());
			doc.addField("item_price", serach.getPrice());
			doc.addField("item_image", serach.getImage());
			doc.addField("item_category_name", serach.getCategoryName());
			// 把文档写入索引库
			try {
				solrServer.add(doc);
				// 提交
				solrServer.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
				return E3Result.fail(500, "SolrServer 通信/解析异常！");
			} catch (IOException e) {
				e.printStackTrace();
				return E3Result.fail(500, "SolrServer I/O异常！");
			}
		}

		return E3Result.ok();
	}

}
