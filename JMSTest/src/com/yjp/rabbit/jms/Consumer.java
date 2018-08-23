package com.yjp.rabbit.jms;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Consumer {
	private final static String QUEUE_NAME = "queue";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 ConnectionFactory factory = new ConnectionFactory();
			 factory.setHost("localhost");
//			 factory.setUsername("guest");
//			 factory.setPassword("guest");
//			 factory.setPort(15672);
			 Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel();
			 channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			 //Queue.DeclareOk dec=channel.queueDeclarePassive(QUEUE_NAME);
			 channel.basicConsume(QUEUE_NAME, true,"tag",new DefaultConsumer(channel){
				 @Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					// TODO Auto-generated method stub
//					super.handleDelivery(consumerTag, envelope, properties, body);
					 System.out.println(new String(body));
				}
			 });
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
