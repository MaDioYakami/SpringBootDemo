package com.springboot.demo;

import com.springboot.demo.activeMq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private Producer producer;

    /**
     * 测试activeMq的队列
     */
    @Test
    public void testQueue() {

        Destination destination = new ActiveMQQueue("mytest.queue");

        for (int i = 0; i < 100; i++) {
            producer.sendMessage(destination, "myname is chhliu!!!" + i);
        }
    }

    /**
     * 测试activeMq的主题
     */
    @Test
    public void testTopic() {
        Destination topic = new ActiveMQTopic("myTest.topic");
        for (int i = 0; i < 10; i++) {
            producer.sendMessage(topic, "发送的主题"+i);
        }


    }


}
