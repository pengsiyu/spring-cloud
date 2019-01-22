package com.pengsiyu.service;


import com.pengsiyu.pojo.Aliyun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    private Aliyun aliyun;

    public String getAliyun(){
        return aliyun.toString();
    }

}
