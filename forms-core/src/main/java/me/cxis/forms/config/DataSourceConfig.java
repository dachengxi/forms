package me.cxis.forms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"me.cxis.forms.dao.mapper"})
@EnableTransactionManagement
public class DataSourceConfig {
}
