package com.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class ActiveMqTopicConsumerTest {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://192.168.56.101:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("MessageTopic");
//		ActiveMQTopic topic = new ActiveMQTopic("MessageTopic");
		MessageConsumer consumer = session.createConsumer(topic);
		System.out.println("接收消息前---");
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				System.out.println("监听消息。。。");
				TextMessage tm = (TextMessage) message;
				try {
					System.out.println(tm.getText());
				} catch (JMSException e) {
					System.err.println("error");
					e.printStackTrace();
				}
			}
		});
	}
}
