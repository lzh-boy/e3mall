package cn.e3mall.common.pojo;

import java.io.Serializable;

import cn.e3mall.common.core.BaseEntity;

/**
 * e3商城自定义响应结构
 *
 * @author colg
 */
public class E3Result extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 响应业务状态 */
	private Integer status;

	/** 响应消息 */
	private String msg;

	/** 响应中的数据 */
	private Object data;

	public static E3Result ok(Object data) {
		return new E3Result(data);
	}

	public static E3Result ok() {
		return new E3Result(null);
	}

	public static E3Result fail(Integer status, String msg) {
		return new E3Result(status, msg, null);
	}

	public static E3Result fail() {
		return new E3Result(500, null, null);
	}

	public E3Result() {

	}

	public E3Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public E3Result(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public E3Result setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public E3Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public E3Result setData(Object data) {
		this.data = data;
		return this;
	}

	public boolean isSuccess() {
		return this.status == 200 ? true : false;
	}

}
