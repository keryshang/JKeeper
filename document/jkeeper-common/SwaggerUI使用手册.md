# SwaggerUI使用手册
### 依赖
```xml
    <!--Swagger3-UI -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
    </dependency>
```
### 开启Swagger支持
```java

@EnableOpenApi  //注解开启Swagger支持
@SpringBootApplication
public class JKeeperRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(JKeeperRedisApplication.class);
    }
}
//创建Swagger配置文件
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.kery.jkeeper.controller")
                .title("JKeeper-nacos")
                .description("JKeeper-nacos模块相关接口文档")
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
//SwaggerApi访问URL
http://localhost:8080/swagger-ui/
```