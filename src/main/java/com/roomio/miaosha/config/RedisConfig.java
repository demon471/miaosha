package com.roomio.miaosha.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    @NacosValue("${spring.redis.host}")
    private String host;

    @NacosValue("${spring.redis.port}")
    private int port;

    @NacosValue("${spring.redis.timeout}")
    private int timeout;

    @NacosValue("${spring.redis.password}")
    private String password;

    @NacosValue("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @NacosValue("${spring.redis.jedis.pool.max-wait}")
    private int maxWaitMillis;

    @NacosValue("${spring.redis.database}")
    private int database;



    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,password,database);
        return jedisPool;
    }
}
