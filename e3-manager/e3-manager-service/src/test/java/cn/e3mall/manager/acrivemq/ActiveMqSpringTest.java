package cn.e3mall.manager.acrivemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 消息队列，activemq 整合 spring 测试
 *
 * @author colg
 */
public class ActiveMqSpringTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMqSpringTest.class);

	/** 初始化spring容器 */
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");;

	/**
	 * 队列模式，发送消息
	 */
	@Test
	public void sendMessage() {
		// 从容器中获得JmsTemplate对象
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		// 从容器中获得一个Destination对象
		Destination destination = applicationContext.getBean(ActiveMQQueue.class);
		// 使用JmsTemplate对象发送消息
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// 创建一个消息并返回
				TextMessage textMessage = session.createTextMessage("Activemq Spring queue message");
				return textMessage;
			}
		});
	}

	/**
	 * 队列模式，接收消息
	 */
	@Test
	public void receiveMessage() throws JMSException {
		// 从容器中获得JmsTemplate对象
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		// 从容器中获得一个Destination对象
		Destination destination = applicationContext.getBean(ActiveMQQueue.class);
		// 使用JmsTemplate对象接收消息
		TextMessage message = (TextMessage) jmsTemplate.receive(destination);
		String text = message.getText();
		LOGGER.info("队列模式接收到的消息： {}", text);
	}

}
