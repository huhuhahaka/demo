package com.example.demo.service;

import com.example.demo.bean.Main;
import com.example.demo.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/10 18:08
 * @Version 1.0
 */
@Service
public class MainService {

    @Autowired
    MainDao mainDao;

    public Main getMainById(Integer id){
        return mainDao.selectById(id);
    }

}
