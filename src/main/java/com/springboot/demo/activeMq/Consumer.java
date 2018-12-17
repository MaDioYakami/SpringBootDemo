package com.springboot.demo.activeMq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue", containerFactory = "queueListenerFactory")
    @SendTo("out.queue")
    public String receiveQueue(String message) {
        System.out.println("Consumer收到的报文为:" + message);
        return "return message" + message;
    }


    @JmsListener(destination = "myTest.topic", containerFactory = "topicListenerFactory")
    public void receiveTopic(String message) {
        System.out.println("topic收到的消息：" + message);
    }

}
