package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.geekshow.Application;
import com.geekshow.sender.Sender;

/**
 * 消息队列测试类
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class QueueTest {

	@Autowired
	private Sender sender;
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void testInfo() throws Exception{
		int flag=0;
		while(true){
			flag++;
			Thread.sleep(2000);
			this.sender.sendInfo("Hello RabbitMQ of Info"+flag);
		}
	}
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void testError() throws Exception{
		
		while(true){
			Thread.sleep(3000);
			this.sender.sendError("Hello RabbitMQ of Error");
		}
	}
}
