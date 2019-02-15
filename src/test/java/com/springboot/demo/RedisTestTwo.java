package com.springboot.demo;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class RedisTestTwo {

    private ShardedJedisPool pool;

    private String redisIp = "localhost";

    public RedisTestTwo() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        // 集群
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo(redisIp, 6379);
//        jedisShardInfo1.setPassword("123456888888");
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1);
        pool = new ShardedJedisPool(config, list);
    }

    @Test
    public void testOne() {
        //连接本地的 Redis 服务
        ShardedJedis jedis = pool.getResource();
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.get("hello2"));
        if(jedis.get("hello2")==null){
            System.out.println("kong");
        }
    }

    @Test
    public void testTwo() {
        //连接本地的 Redis 服务
        ShardedJedis jedis = pool.getResource();
        System.out.println("连接成功");
        System.out.println("======================key==========================");
        // 清空数据
//        System.out.println("清空库中所有数据：" + jedis.flushDB());
        String set = jedis.set("hello", "helloWorld");
        System.out.println(set);
//        jedis.del("hello");
        System.out.printf(jedis.get("hello"));
        if (jedis!=null){
            jedis.close();
        }

    }


}
