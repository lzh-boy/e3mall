package cn.e3mall.search.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.search.core.BaseServiceImpl;
import cn.e3mall.search.service.TbItemService;

/**
 * 监听商品添加消息，接收消息后，将对应的商品信息同步到索引库
 *
 * @author colg
 */
public class TbItemAddMessageListener extends BaseServiceImpl implements MessageListener {

	@Autowired
	private TbItemService tbItemService;

	/**
	 * 订阅"商品添加"主题，获取"商品添加"消息，同步索引库
	 */
	@Override
	public void onMessage(Message message) {
		try {
			// 休眠一秒，防止事务未提交
			Thread.sleep(1000);
			// 从消息中取消息id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Long id = Long.parseLong(text);
			tbItemService.addDocument(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
