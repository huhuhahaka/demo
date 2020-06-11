package com.example.demo.aspect;


import com.example.demo.annotation.SwitchDataSource;
import com.example.demo.utils.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/10 17:51
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class DataSourceAspect {

    @Before("@annotation(switchDataSource)")
    public void before(JoinPoint joinPoint, SwitchDataSource switchDataSource){
        log.info("数据源切换为: {}", switchDataSource.value());

        if (!switchDataSource.value().equals(DataSourceContextHolder.getDataSource())) {
            DataSourceContextHolder.setDataSource(switchDataSource.value());
        }
    }


    @After("@annotation(switchDataSource)")
    public void after(JoinPoint joinPoint, SwitchDataSource switchDataSource){

    }
}
