package com.example.wing.config;

//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.time.Duration;

@Configuration
//@AutoConfigureAfter
@EnableCaching
public class RedisConfig {
    /**
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
    */

    @Bean(name = "friendRedisTemplate")
    public RedisTemplate friendRedisTemplate(@Value("${spring.redis.friend-redis.host}") String host,
                                             @Value("${spring.redis.friend-redis.port}") int port,
                                             @Value("${spring.redis.friend-redis.password}") String password,
                                             @Value("${spring.redis.friend-redis.database}") int database) {
        return redisTemplateModel(host, port, password, database);
    }


    @Bean(name = "accountRedisTemplate")
    public RedisTemplate accountRedisTemplate(@Value("${spring.redis.account-redis.host}") String host,
                                             @Value("${spring.redis.account-redis.port}") int port,
                                             @Value("${spring.redis.account-redis.password}") String password,
                                             @Value("${spring.redis.account-redis.database}") int database) {
        return redisTemplateModel(host, port, password, database);
    }
    public RedisTemplate redisTemplateModel(String host, int port, String password, int database){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        configuration.setDatabase(database);
        /* ============ common config ======= */
        if (!ObjectUtils.isEmpty(password)) {
            RedisPassword redisPassword = RedisPassword.of(password);
            configuration.setPassword(redisPassword);
        }
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        /* ========== 连接池配置 ============== */
        /**
        genericObjectPoolConfig.setMaxTotal(maxActive);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
        */
        /* ========= lettuce pool ========= */
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        /* ============ 超时时间可配置，也可默认 ======== */
        //builder.commandTimeout(Duration.ofSeconds(timeout));
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();

        /* ========= 创建 template ========= */
        return createRedisTemplate(connectionFactory);
    }
    /**
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory);
    }
    */

    public RedisTemplate createRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
