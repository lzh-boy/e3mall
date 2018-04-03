package cn.e3mall.common.vo;

import java.io.Serializable;
import java.util.List;

import cn.e3mall.common.core.BaseEntity;

/**
 * 全文检索返回结果
 *
 * @author colg
 */
public class SearchResult extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 总记录数 */
	private Long recourdCount;
	/** 总页数 */
	private Integer totalPages;
	/** 结果集 */
	private List<TbItemSerach> itemSerachs;

	public Long getRecourdCount() {
		return recourdCount;
	}

	public void setRecourdCount(Long recourdCount) {
		this.recourdCount = recourdCount;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public List<TbItemSerach> getItemSerachs() {
		return itemSerachs;
	}

	public void setItemSerachs(List<TbItemSerach> itemSerachs) {
		this.itemSerachs = itemSerachs;
	}

}
