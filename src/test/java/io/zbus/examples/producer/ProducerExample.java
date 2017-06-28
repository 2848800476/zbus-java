package io.zbus.examples.producer;

import io.zbus.mq.Broker;
import io.zbus.mq.Message;
import io.zbus.mq.Producer; 

public class ProducerExample { 
	public static void main(String[] args) throws Exception { 
		Broker broker = new Broker("localhost:15555"); 
		  
		Producer p = new Producer(broker);
		p.declareTopic("hong"); 
		 
		Message msg = new Message();
		msg.setTopic("hong");
		msg.setTag("group1.xxx");
		msg.setBody("hello " + System.currentTimeMillis()); 
		
		Message res = p.publish(msg);
		System.out.println(res);   
		 
		broker.close();
	} 
}
