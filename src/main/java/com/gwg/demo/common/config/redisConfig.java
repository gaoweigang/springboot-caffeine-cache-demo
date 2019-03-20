package com.gwg.demo.common.config;

/*import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;*/

import java.util.HashMap;
import java.util.Map;

/**
 * 设置redis策略
 * 如果省略了(也就是可以不要这个类)，就使用redis默认策略,比如设置到redis里面的值永不过期
 */
//@Configuration
/*@Deprecated
public class redisConfig extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(10);//设置redis默认过期时间为10秒，如果不设置，则永不过期
        // 还可以具体指定某个缓存的过期时间
        Map<String, Long> expires = new HashMap<String, Long>();
        expires.put("dicContent", 1000L);//设置字典过期时间
        expires.put("user-role", 300L);//设置用户角色信息过期时间
        redisCacheManager.setExpires(expires);
        return redisCacheManager;
    }
}*/
