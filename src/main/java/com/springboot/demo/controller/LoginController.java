package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@Controller
public class LoginController {

    /**
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "helloWorld!";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
