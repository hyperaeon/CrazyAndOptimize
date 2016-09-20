package com.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqQueueConsumerTest {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER, 
				ActiveMQConnection.DEFAULT_PASSWORD, 
				"tcp://192.168.56.101:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("MessageQueue");
		MessageConsumer consumer = session.createConsumer(destination);
		while(true) {
			ObjectMessage message = (ObjectMessage) consumer.receive(10000);
			if (null != message) {
				String messageContent = (String) message.getObject();
				System.out.println("收到的消息： " + messageContent);
			} else {
				break;
			}
		}
	}
}
