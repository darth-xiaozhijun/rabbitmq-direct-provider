package com.geekshow.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Administrator
 *
 */
@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	//exchange 交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;
	
	//routingkey INFO日志路由键
	@Value("${mq.config.queue.info.routing.key}")
	private String infoRoutingkey;
	
	//routingkey ERROR日志路由键
	@Value("${mq.config.queue.error.routing.key}")
	private String errorRoutingkey;
		
	/*
	 * 发送INFO消息的方法
	 */
	public void sendInfo(String msg){
		//向消息队列发送消息
		//参数一：交换器名称。
		//参数二：路由键
		//参数三：消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, this.infoRoutingkey, msg);
	}
	
	/*
	 * 发送ERROR消息的方法
	 */
	public void sendError(String msg){
		//向消息队列发送消息
		//参数一：交换器名称。
		//参数二：路由键
		//参数三：消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, this.errorRoutingkey, msg);
	}
}
