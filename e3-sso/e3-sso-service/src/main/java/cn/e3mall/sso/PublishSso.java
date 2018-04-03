package cn.e3mall.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo服务发布不使用tomcat
 *
 * @author colg
 */
public class PublishSso {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublishSso.class);

	private static final String CLASSPATH_SPRING_APPLICATION_CONTEXT_XML = "classpath:spring/applicationContext-*.xml";

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CLASSPATH_SPRING_APPLICATION_CONTEXT_XML);
		LOGGER.info("Dubbo Publishing SearchService - {}", "http://127.0.0.1:8087/");

		synchronized (PublishSso.class) {
			PublishSso.class.wait();
		}
	}
}