package com.pengsiyu.controller;

import com.pengsiyu.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping("/hello")
    public String home() {
        return "hi "  + ",i am from value:" + indexService.getAliyun();
    }

}
