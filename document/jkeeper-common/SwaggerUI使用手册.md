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
```