package com.kery.jkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/26
 */
@EnableOpenApi
@EnableDiscoveryClient
@SpringBootApplication
public class JkeeperSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(JkeeperSentinelApplication.class);
    }
}
