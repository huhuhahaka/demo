package com.example.demo.controller;

import com.example.demo.annotation.SwitchDataSource;
import com.example.demo.bean.Main;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/10 18:16
 * @Version 1.0
 */
@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/test")
    @SwitchDataSource("test")
    public Main getMainById(Integer id){
        return mainService.getMainById(id);
    }


}
