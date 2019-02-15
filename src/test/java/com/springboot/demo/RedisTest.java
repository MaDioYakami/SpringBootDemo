package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisConnectionFactory factory;


    @Test
    public void testRedis() {
        //得到一个连接
        RedisConnection conn = factory.getConnection();
        conn.set("hello".getBytes(), "world".getBytes());
        System.out.println(new String(conn.get("hello".getBytes())));
    }


    @Test
    public void testRedisTwo() {
        //得到一个连接
        RedisConnection conn = factory.getConnection();
        byte[] bytes = conn.get("hello".getBytes());
        if (bytes==null){
            System.out.printf("1");
        }else {
            String s = new String(bytes);
            System.out.printf(s);
        }
        if (conn!=null){
            conn.close();
        }

    }


}
