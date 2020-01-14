package com.demo.springbootmybatis.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Autowired
    WallFilter wallFilter;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        DruidDataSource dataSource = new DruidDataSource();
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter);
        dataSource.setProxyFilters(filters);
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, Object> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "ymj15345");
        initParams.put("allow", "127.0.0.1");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, Object> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }

    /*
    * MySQL批量语句处理功能实现
    * 配置过滤器WallFilter
    * */
    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilterBean = new WallFilter();
        wallFilterBean.setConfig(wallConfig());
        return wallFilterBean;
    }

    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfigBean = new WallConfig();
        wallConfigBean.setMultiStatementAllow(true);
        return wallConfigBean;
    }
}
