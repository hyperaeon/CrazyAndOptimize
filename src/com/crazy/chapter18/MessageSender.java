package com.crazy.chapter18;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageSender {

//	public MessageSender(){
//		
//	}
//	public void sendMessage() throws NamingException, JMSException {
//		final String CONNECTION_FACTORY_JNDI = "weblogic. jms.ConnectionFactory";
//		Context ctx = getInitialContext();
//		ConnectionFactory connectionFactory = (ConnectionFactory) ctx
//				.lookup(CONNECTION_FACTORY_JNDI);
//		Destination dest = (Destination) ctx.lookup("MessageQueue");
//		Connection conn = connectionFactory.createConnection();
//		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
//		MessageProducer sender = session.createProducer(dest);
//		sender.setDeliveryMode(DeliveryMode.PERSISTENT);
//		sender.setTimeToLive(20000);
//		TextMessage msg = session.createTextMessage();
//		msg.setText("Hello");
//		sender.send(msg);
//		msg.setText("Welcome");
//		sender.send(msg);
//		session.close();
//		conn.close();
//	}
//
//	private Context getInitialContext() {
//		final String INIT_FACTORY = "weblogic.jndi.WLInitialContextFactory";
//		final String SERVER_URL = "t3://localhost:7001";
//		Context ctx = null;
//		try {
//			Properties props = new Properties();
//			props.put(Context.INITIAL_CONTEXT_FACTORY, INIT_FACTORY);
//			props.put(Context.PROVIDER_URL, SERVER_URL);
//			ctx = new InitialContext(props);
//		} catch (NamingException e) {
//			System.err.println("不能链接Weblogic Server 在：" + SERVER_URL);
//			e.printStackTrace();
//		}
//		return ctx;
//	}

	public static void main(String[] args) throws Exception {
		MessageSender mp = new MessageSender();
		System.out.println("sd");
//		mp.sendMessage();
	}
}
