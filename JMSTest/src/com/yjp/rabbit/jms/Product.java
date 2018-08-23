package com.yjp.rabbit.jms;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Product {
	private final static String QUEUE_NAME = "queue";
	public static void main(String[] args) {
		
			 try {
				 ConnectionFactory factory = new ConnectionFactory();
				 factory.setHost("localhost");
				 Connection connection = factory.newConnection();
				 Channel channel = connection.createChannel();
				 channel.queueDeclare(QUEUE_NAME,false,false,false,null);
				 channel.basicPublish("", QUEUE_NAME, null, "hello world".getBytes());
				 channel.close();
				 connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
