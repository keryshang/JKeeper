package com.kery.jkeeper.config;

import com.kery.jkeeper.common.config.BaseSwaggerConfig;
import com.kery.jkeeper.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author:: Kery
 * @description:
 * @date: 2023/9/20 16:03
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.kery.jkeeper.controller")
                .title("JKeeper-Feign")
                .description("JKeeper-Feign-Provider-A模块相关接口文档")
                .contactName("Kery")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}
