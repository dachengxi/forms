package me.cxis.forms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"me.cxis.forms.dao.mapper"})
public class DataSourceConfig {
}
