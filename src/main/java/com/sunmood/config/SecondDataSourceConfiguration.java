package com.sunmood.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = SecondDataSourceConfiguration.PACKAGE,sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfiguration {

    //配置使用该数据源的mapper接口包的位置
    static final String PACKAGE = "com.sunmood.mapper.second";

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "hikari.second")//自动配置bean属性
    public HikariDataSource createDataSource(){
        return new HikariDataSource();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(this.createDataSource());
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondDataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

}
