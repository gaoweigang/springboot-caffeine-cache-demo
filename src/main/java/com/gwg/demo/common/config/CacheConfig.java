package com.gwg.demo.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CacheConfig 使用cafeine cache
 * <p>
 * Created by Bob Jiang on 2018/11/8
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private CaffeineCacheProperties properties;

    @Bean
    public CacheManager caffeineCacheManager() {
        List<CaffeineCache> caches = new ArrayList<CaffeineCache>();
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        if (!CollectionUtils.isEmpty(properties.getItem())) {
            properties.getItem().forEach(i -> {
                CaffeineCache cache;
                if (i.getRecordStats()) {
                    cache = new CaffeineCache(i.getCacheName(), Caffeine.newBuilder()
                            .recordStats()
                            .expireAfterWrite(i.getExpireSeconds(), TimeUnit.SECONDS)
                            .initialCapacity(i.getInitSize())
                            .maximumSize(i.getMaxSize())
                            .build());
                } else {
                    cache = new CaffeineCache(i.getCacheName(), Caffeine.newBuilder()
                            .expireAfterWrite(i.getExpireSeconds(), TimeUnit.SECONDS)
                            .initialCapacity(i.getInitSize())
                            .maximumSize(i.getMaxSize())
                            .build());
                }
                caches.add(cache);
            });
            cacheManager.setCaches(caches);
        }
        return cacheManager;
    }

}
