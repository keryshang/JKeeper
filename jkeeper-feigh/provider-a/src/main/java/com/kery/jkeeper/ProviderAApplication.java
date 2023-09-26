package com.kery.jkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@EnableOpenApi
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAApplication.class);
    }
}
