# SpringBootAdmin监控使用手册
### 搭建SpringBootAdmin监控项目
#### 依赖
```xml
        <!--整合SpringBootAdmin监控-->
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-server</artifactId>
    </dependency>
        <!--整合SpringBoot鉴权-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
        <!--对nacos注册中心的支持-->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
```
#### 配置文件
```yaml
spring:
  profiles:
    active: dev
  application:
    name: jkeeper-monitor
  security: # 配置登录用户名和密码
    user:
      name: jkeeper
      password: 123456
  boot: # 不显示admin-server的监控信息
    admin:
      discovery:
        ignored-services: ${spring.application.name}
```
### 项目整合SpringBootAdmin监控
#### 依赖
```xml
    <!--SpringBoot健康监控-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```
#### 配置文件
```yaml
management: #开启SpringBoot Admin的监控
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: always
```