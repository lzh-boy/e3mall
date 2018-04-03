package cn.e3mall.sso.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.sso.service.TbUserService;
import cn.e3mall.sso.service.TokenService;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author colg
 */
public abstract class BaseController {

	@Autowired
	protected TbUserService tbUserService;
	@Autowired
	protected TokenService tokenService;
}
