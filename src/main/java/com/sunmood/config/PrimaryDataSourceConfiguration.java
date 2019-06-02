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
@MapperScan(basePackages = PrimaryDataSourceConfiguration.PACKAGE,sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSourceConfiguration {

    static final String PACKAGE = "com.sunmood.mapper.primary";

//    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "hikari.primary")//自动配置bean属性
    public HikariDataSource createDataSource(){
        return new HikariDataSource();
    }

//    @Primary
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(this.createDataSource());
    }

//    @Primary
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

}
