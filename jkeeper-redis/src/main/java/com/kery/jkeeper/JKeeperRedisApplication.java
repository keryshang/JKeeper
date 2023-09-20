package com.kery.jkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author:: Kery
 * @description:
 * @date: 2023/9/20 16:00
 **/
@EnableDiscoveryClient
@EnableOpenApi
@SpringBootApplication
public class JKeeperRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(JKeeperRedisApplication.class);
    }
}
