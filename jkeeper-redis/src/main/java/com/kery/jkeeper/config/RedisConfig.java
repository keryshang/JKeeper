package com.kery.jkeeper.config;

import com.kery.jkeeper.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author:: Kery
 * @description:
 * @date: 2023/9/20 16:03
 **/
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
