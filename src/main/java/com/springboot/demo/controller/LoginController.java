package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@Controller
public class LoginController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        System.out.println(name);
        System.out.println(pwd);
        ModelAndView modelAndView = new ModelAndView("/home.html");
        modelAndView.addObject("name",name);
        return modelAndView;
    }

    @RequestMapping("/loginIndex")
    public String loginIndex(){
        String s="hello";
        return "index";
    }








}
