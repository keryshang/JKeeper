# SpringCloudGateway使用手册

## SpringCloudGateway原理
Gateway关键特性：路由、断言、过滤
![](https://pic.imgdb.cn/item/6513c7d6c458853aef32c17f.png)
1. Route(路由)：
路由是构建网关的基本模块，由ID,目标URI,一系列的断言和过滤器组成，如果断言为true，则匹配该路由。
2. Predicate(断言)：
参考java8的java.util.function.Predicate开发人员可以匹配HTTP请求中的所有内容（例如请求头、请求参数），如果请求与断言相匹配则进行路由。
3. Filter(过滤):
指的是由Spring框架中GatewayFilter实例，使用过滤器，可以在请求被路由之前或者之后对请求进行修改。
![](https://pic.imgdb.cn/item/6513c8efc458853aef331031.jpg)
web请求，通过一些匹配条件，定位到真正的服务节点。并在这个转发过程的前和后，通过Filter进行一些精细化控制和管理，predicate就是我们的匹配条件，有了这两个元素，再加上目标uri，就可以实现一个具体的路由了。
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
> 通过网关请求样例  
> http://192.168.1.106/jkeeper-nacos/nacos/getAge