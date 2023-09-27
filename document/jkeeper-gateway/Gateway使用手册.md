# SpringCloudGateway使用手册
### 依赖
```xml
        <!--如果父类项目引用了spring-boot-starter-web依赖，需要去除，SpringCloudGateway使用netty+webflux实现，webflux与web冲突-->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </exclusion>
        <!--对SpringCloudGateway的支持-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
        <!--对负载均衡的支持，不加会报503-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-loadbalancer</artifactId>
        </dependency>
        <!--对Nacos注册中心的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!--对Nacos配置中心的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```
### 配置文件
```yaml
spring:
  cloud:
    gateway:
      discovery:
        locator:
          #开启从注册中心动态创建路由的功能，利用微服务名进行路由
          enabled: true
          #开启小写验证，默认根据服务名查找都是用的全大写
          lower-case-service-id: true
      routes: #配置路由路径
        - id: jkeeper-nacos
          uri: lb://jkeeper-nacos
          # 断言,路径相匹配的进行路由
          predicates:
            - Path=/jkeeper-nacos/**
          filters:
            - StripPrefix=1
        - id: jkeeper-redis
          uri: lb://jkeeper-redis
          # 断言,路径相匹配的进行路由
          predicates:
            - Path=/jkeeper-redis/**
          filters:
            - StripPrefix=1
logging:
  level:
    root: info
    com.kery.jkeeper: debug
```