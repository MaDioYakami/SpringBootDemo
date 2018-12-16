package com.springboot.demo.Task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {

    @Scheduled(cron = "* * */5 * * ?")
    public void testOneTask(){
        System.out.println("测试客户！");
    }
}
