package com.example.demo.utils;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/10 17:59
 * @Version 1.0
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * @Description 设置数据源
     * @param dataSource
     * @return void
     */
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    /**
     * @Description 获取数据源
     * @param  
     * @return java.lang.String
     */
    public static String getDataSource() {
        return contextHolder.get();
    }



    /**
     * @Description 清除数据源
     * @param  
     * @return void
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }

    
}
