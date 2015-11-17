package com.yt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 使用spring注解,加载配置文件
 * redis配置文件所有信息
 * Created by yangtao on 15/11/17.
 */
@Configuration
@PropertySource({"classpath:redis.properties", "classpath:jdbc.properties"})
public class RedisConf {

    @Value(value = "${redis.host}")
    private String host;
    @Value(value = "${redis.port}")
    private String port;
    @Value(value = "${redis.pass}")
    private String pass;
    @Value(value = "${redis.maxIdle}")
    private String maxIdle;
    @Value(value = "${redis.maxActive}")
    private String maxActive;
    @Value(value = "${redis.maxWait}")
    private String maxWait;
    @Value(value = "${redis.testOnBorrow}")
    private String testOnBorrow;
    @Value(value = "${jdbc.driver}")
    private String driver;

}
