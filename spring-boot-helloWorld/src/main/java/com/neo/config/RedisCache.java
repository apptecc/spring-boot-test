package com.neo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisCache implements ApplicationContextAware, InitializingBean {

    @Autowired
    public static JedisCluster jedisCluster;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String hello() {

        String hello = jedisCluster.get("name");
        return hello;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");
    }
}
