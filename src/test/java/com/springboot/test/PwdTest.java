package com.springboot.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PwdTest.class)
@ComponentScan("com.springboot")
@WebAppConfiguration
public class PwdTest {
    @Autowired
    StringEncryptor encryptor;

    @Value("${test.pwd}")
    private String pwd;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://47.97.192.116:3306/sell?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8");
        String name = encryptor.encrypt("你的数据库名");
        String password = encryptor.encrypt("你的数据库密码");
//        System.out.println(url);
//        System.out.println(name);
        System.out.println(password);
        Assert.assertTrue(name.length() > 0);
        Assert.assertTrue(password.length() > 0);
    }

    @Test
    public void getEncPass() {
        System.out.println(pwd);
    }

}
