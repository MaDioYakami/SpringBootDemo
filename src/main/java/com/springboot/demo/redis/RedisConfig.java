package com.springboot.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfig {
    @Value("${redis.port}")
    private int port;
    @Value("${redis.hostName}")
    private String hostName;


    @Bean
    public RedisConnectionFactory redisCF() {
        //如果什么参数都不设置，默认连接本地6379端口
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(port);
        factory.setHostName(hostName);
        return factory;
    }
}
