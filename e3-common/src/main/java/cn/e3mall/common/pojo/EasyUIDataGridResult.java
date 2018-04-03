package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

import cn.e3mall.common.core.BaseEntity;

/**
 * EasyUI 表格数据格式
 *
 * @author colg
 */
public class EasyUIDataGridResult extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long total;
	private List<?> rows;

	/**
	 * 构造表格数据
	 * 
	 * @param data
	 * @return
	 */
	public static EasyUIDataGridResult ok(Object data) {
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		if (data instanceof Page<?>) {
			Page<?> page = (Page<?>) data;
			easyUIDataGridResult.setRows(page.getResult()).setTotal(page.getTotal());
		} else {
			List<?> list = (List<?>) data;
			easyUIDataGridResult.setRows(list).setTotal((long) list.size());
		}
		return easyUIDataGridResult;
	}

	public EasyUIDataGridResult() {
	}

	public EasyUIDataGridResult(Long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public EasyUIDataGridResult setRows(List<?> rows) {
		this.rows = rows;
		return this;
	}

}
