package cn.e3mall.sso.service;

import cn.e3mall.common.pojo.E3Result;

/**
 * 
 *
 * @author colg
 */
public interface TokenService {

	/**
	 * 根据token查询用户信息
	 * 
	 * @param token
	 * @return
	 */
	E3Result getUserByToken(String token);
}
