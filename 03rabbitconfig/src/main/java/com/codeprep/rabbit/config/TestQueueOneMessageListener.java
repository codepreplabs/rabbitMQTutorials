package com.codeprep.rabbit.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TestQueueOneMessageListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		System.out.println(new String(arg0.getBody()));
	}

}
