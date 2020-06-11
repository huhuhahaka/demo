package com.example.demo.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.demo.utils.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/11 15:01
 * @Version 1.0
 */
@Configuration
public class DataSourceConfig {

    //todo 引入公共配置 如 驱动 用户名 密码 等
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource test() {
        return DataSourceBuilder.create().build();
    }

    //todo 引入其他数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2() {
        return DataSourceBuilder.create().build();
    }


    // 动态数据源
    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("test") DataSource test, @Qualifier("test2") DataSource test2) {

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("test", test);
        dsMap.put("test2", test2);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dsMap);
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(test);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource)
            throws Exception {
        //使用 mybatis-plus 不能使用原生的 SqlSessionFactory。 用哪个启动的可从控制台看出
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DynamicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }




}
