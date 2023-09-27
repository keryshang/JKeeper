package com.kery.jkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JKeeperGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(JKeeperGatewayApplication.class);
    }
}
