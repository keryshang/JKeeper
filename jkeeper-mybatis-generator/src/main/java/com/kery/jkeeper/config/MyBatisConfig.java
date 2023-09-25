package com.kery.jkeeper.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@Configuration
@MapperScan({"com.kery.jkeeper.mapper"})
public class MyBatisConfig {
}
