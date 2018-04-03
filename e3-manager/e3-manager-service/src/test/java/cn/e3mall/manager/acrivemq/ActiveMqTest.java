package cn.e3mall.manager.acrivemq;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息队列，activemq 测试
 *
 * @author colg
 */
public class ActiveMqTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMqTest.class);

	/**
	 * tcp:// 规定写法
	 * 
	 * 61616 activemq服务监控端口
	 */
	private static final String BROCKER_URL = "tcp://192.168.21.102:61616";

	/**
	 * 点到点形式（队列形式），发送消息
	 * 
	 */
	@Test
	public void testQueueProducre() throws JMSException {
		// 1、创建一个连接工厂对象，需要指定服务的ip及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROCKER_URL);
		// 2、使用工厂对象来创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 3、开启连接，调用Connection对象的start方法。
		connection.start();
		// 4、创建一个Session对象。
		// 第一个参数：是否开启事务（如果消息发布失败，重发，一般不开启事务，如果开启事务，第二个参数无意义）
		// 第二个参数：应答模式。一般自动应答（AUTO_ACKNOWLEDGE）或者手动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用队列 queue
		// queue 继承 Destination
		Queue queue = session.createQueue("test-queue");
		// 6、使用Session对象创建一个Producre对象。生产者
		MessageProducer producer = session.createProducer(queue);
		// 7、创建一个Message对象，可以使用TestMessage。
		TextMessage textMessage = session.createTextMessage("Hello Activemq, this is my first test.");
		// 8 、使用Producre对象发送消息
		producer.send(textMessage);
		// 9、关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 * 点对点模式，接收消息
	 * 
	 */
	@Test
	public void testQueueConsumer() throws JMSException, IOException {
		// 第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROCKER_URL);
		// 第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接。调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象。和发送端保持一致queue，并且队列的名称一致。
		Queue queue = session.createQueue("test-queue");
		// 第六步：使用Session对象创建一个Consumer对象。
		MessageConsumer consumer = session.createConsumer(queue);
		// 第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					// 取消息的内容
					String text = textMessage.getText();
					// 第八步：打印消息。
					LOGGER.info("队列模式接收到的消息： {}", text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		// 等待键盘输入
		System.in.read();
		// 第九步：关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

	/**
	 * 发布/订阅模式 生产者
	 * 
	 */
	@Test
	public void testTopicProducer() throws JMSException {
		// 1、创建一个连接工厂对象，需要指定服务的ip及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROCKER_URL);
		// 2、使用工厂对象来创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 3、开启连接，调用Connection对象的start方法。
		connection.start();
		// 4、创建一个Session对象。
		// 第一个参数：是否开启事务（如果消息发布失败，重发，一般不开启事务，如果开启事务，第二个参数无意义）
		// 第二个参数：应答模式。一般自动应答（AUTO_ACKNOWLEDGE）或者手动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用队列 queue
		// topic 继承 Destination
		Topic topic = session.createTopic("test-topic");
		// 6、使用Session对象创建一个Producre对象。生产者
		MessageProducer producer = session.createProducer(topic);
		// 7、创建一个Message对象，可以使用TestMessage。
		TextMessage textMessage = session.createTextMessage("Tocip Message.");
		// 8 、使用Producre对象发送消息
		producer.send(textMessage);
		// 9、关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 * 发布/订阅模式，消费者
	 * 
	 */
	@Test
	public void testTopicConsumer() throws JMSException, IOException {
		// 第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROCKER_URL);
		// 第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接。调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象。和发送端保持一致queue，并且队列的名称一致。
		Topic topic = session.createTopic("test-topic");
		// 第六步：使用Session对象创建一个Consumer对象。
		MessageConsumer consumer = session.createConsumer(topic);
		// 第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					// 取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					LOGGER.info("发布/订阅模式接收到的消息： {}", text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		LOGGER.info("{} 已经启动", "topic 消费者3");
		// 等待键盘输入
		System.in.read();
		// 第九步：关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
}
