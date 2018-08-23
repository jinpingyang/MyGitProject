package com.yjp.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;


public class Producer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null ;
		try{
//			ConnectionFactory faction=new ActiveMQConnectionFactory("tcp://localhost:61616");
			ConnectionFactory faction = new ActiveMQConnectionFactory();
			connection = faction.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("queue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = new ActiveMQTextMessage();
			message.setText("hell word");
			producer.send(destination,message);
			
		}catch (Exception e) {
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
