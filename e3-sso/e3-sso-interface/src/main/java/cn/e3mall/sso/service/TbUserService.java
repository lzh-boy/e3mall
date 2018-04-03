package cn.e3mall.sso.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.manager.pojo.TbUser;

/**
 * 
 *
 * @author colg
 */
public interface TbUserService {

	TbUser findById(Long id);

	/**
	 * 注册,校验数据
	 * 
	 * @param param
	 *            参数
	 * @param type
	 *            参数类型 - 1:用户名, 2:手机, 3:邮箱
	 * @return
	 */
	E3Result checkData(String param, Integer type);

	/**
	 * 注册用户,新增
	 * 
	 * @param tbUser
	 * @return
	 */
	E3Result createUser(TbUser tbUser);

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	E3Result userLogin(String username, String password);

}
