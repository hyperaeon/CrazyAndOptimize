package com.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqTopicProducerTest {

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
		MessageProducer producer = session.createProducer(topic);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		TextMessage message = session.createTextMessage();
		message.setText("this is the first topic message");
		producer.send(message);
		System.out.println("发送消息结束");
	}
}
