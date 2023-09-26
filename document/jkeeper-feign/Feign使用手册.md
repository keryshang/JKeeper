# Feign使用手册
### 依赖
#### 服务提供端
```xml
        <!--整合Feign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!--OKHTTP连接池-->
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-okhttp</artifactId>
        </dependency>
        <!--对Nacos注册中心的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
```
#### 服务消费端
```xml
        <!--整合Feign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!--OKHTTP连接池-->
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-okhttp</artifactId>
        </dependency>
        <!--对Nacos注册中心的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!--对Feign调用负载均衡的支持，缺少该依赖会报java.net.UnknownHostException异常-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-loadbalancer</artifactId>
        </dependency>
```
### 配置文件
#### 服务提供端
```yaml
feign:
  okhttp:
    enabled: true
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000
        loggerLevel: basic
```
#### 服务消费端
```yaml
feign:
  okhttp:
    enabled: true
```

### Feign远程调用工作原理
![](https://pic.imgdb.cn/item/651231d2c458853aef9deaee.png)