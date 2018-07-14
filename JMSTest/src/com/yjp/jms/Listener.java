package com.yjp.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof TextMessage) {
			TextMessage message = (TextMessage) arg0;
			try {
				System.out.println(message.getText());
				message.acknowledge();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
