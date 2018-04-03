package cn.e3mall.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo服务发布不使用tomcat
 *
 * @author colg
 */
public class PublishManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublishManager.class);

	private static final String CLASSPATH_SPRING_APPLICATION_CONTEXT_XML = "classpath:spring/applicationContext-*.xml";

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {
		// 加载 Spring 容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CLASSPATH_SPRING_APPLICATION_CONTEXT_XML);
		LOGGER.info("Dubbo Publishing ManagerService - {}", "http://localhost:8080/");
		// 保持启动状态
		/*
		while (true) {
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/

		// 保持启动状态
		synchronized (PublishManager.class) {
			// 调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
			PublishManager.class.wait();
		}
	}
}
