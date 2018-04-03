package cn.e3mll.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo服务发布不使用tomcat
 *
 * @author colg
 */
public class PublishCart {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublishCart.class);

	private static final String CLASSPATH_SPRING_APPLICATION_CONTEXT_XML = "classpath:spring/applicationContext-*.xml";

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CLASSPATH_SPRING_APPLICATION_CONTEXT_XML);
		LOGGER.info("Dubbo Publishing CartService - {}", "http://127.0.0.1:8089/");

		synchronized (PublishCart.class) {
			PublishCart.class.wait();
		}
		// API 配置
		// // 当前应用配置
		// ApplicationConfig applicationConfig = new ApplicationConfig();
		// applicationConfig.setName("e3-cart");
		// // 连接注册中心配置
		// RegistryConfig registry = new RegistryConfig();
		// registry.setProtocol("zookeeper");
		// registry.setAddress("192.168.21.101:2181");
		// // 服务提供者协议配置
		// ProtocolConfig protocolConfig = new ProtocolConfig();
		// protocolConfig.setName("dubbo");
		// protocolConfig.setPort(20884);
		// // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
		// // 服务提供者暴露服务配置
		// // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		// ServiceConfig<TbItemService> serviceConfig = new ServiceConfig<>();
		// serviceConfig.setApplication(applicationConfig);
		// serviceConfig.setRegistry(registry);
		// serviceConfig.setProtocol(protocolConfig);
		// serviceConfig.setInterface(TbItemService.class);
		// serviceConfig.setRef(tbItemService);
	}
}
