//package com.activemq;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.DeliveryMode;
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.ObjectMessage;
//import javax.jms.Session;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//public class ActiveMqQueueProducerTest {
//
//	public static void main(String[] args) throws JMSException, InterruptedException {
//		ConnectionFactory factory = new ActiveMQConnectionFactory(
//				ActiveMQConnection.DEFAULT_USER,
//				ActiveMQConnection.DEFAULT_PASSWORD,
//				"tcp://192.168.56.101:61616");
//		Connection connection = factory.createConnection();
//		connection.start();
//		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//		Destination destination = session.createQueue("MessageQueue");
//		MessageProducer producer = session.createProducer(destination);
//		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//
//		for (int i = 0; i < 1; i++) {
//			Thread.sleep(2000);
//			ObjectMessage message = session.createObjectMessage("queue message");
//			producer.send(message);
//			session.commit();
//		}
//		System.out.println("消息发送完毕");
//	}
//}
