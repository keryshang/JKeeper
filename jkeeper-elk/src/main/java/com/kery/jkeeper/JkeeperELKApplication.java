package com.kery.jkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * Description:
 * Author: Kery
 * Date: 2023/11/15
 */
@EnableOpenApi
@EnableDiscoveryClient
@SpringBootApplication
public class JkeeperELKApplication {
    public static void main(String[] args) {
        SpringApplication.run(JkeeperELKApplication.class);
    }
}
