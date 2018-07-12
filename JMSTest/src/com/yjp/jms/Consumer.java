package com.yjp.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null ;
		try {
			ConnectionFactory faction = new ActiveMQConnectionFactory();
			connection = faction.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("queue");
			MessageConsumer consumer = session.createConsumer(destination);
//			TextMessage message = (TextMessage) consumer.receive(); 
//			if(message != null)
//				System.out.println(message.getText());
			while(true){
				consumer.setMessageListener(new Listener());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(connection != null )
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
