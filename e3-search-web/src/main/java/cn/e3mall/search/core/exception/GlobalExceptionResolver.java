package cn.e3mall.search.core.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 *
 * @author colg
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		if (handler instanceof HandlerMethod) {
			// 解析json
		}

		// 打印控制台
		ex.printStackTrace();
		// 写日志
		LOGGER.error("系统发生异常: {}", ex.getMessage());
		// 发邮件、发短信

		// 显示错误页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/exception");
		return modelAndView;
	}

}
