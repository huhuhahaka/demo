package com.example.demo.aspect;


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

    @Before("@annotation(com.example.demo.annotation.SwitchDataSource)")
    public void before(JoinPoint joinPoint){


    }


    @After("@annotation(com.example.demo.annotation.SwitchDataSource)")
    public void after(JoinPoint joinPoint){

    }
}
