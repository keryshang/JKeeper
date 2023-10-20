# Seata使用手册
Seata官方网站：https://seata.io/zh-cn/docs/overview/what-is-seata.html
### 依赖
```xml
        <!--对Seata的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
        </dependency>
        <!--集成druid连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
        </dependency>
        <!--Mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--MyBatis分页插件starter-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
        </dependency>
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
        <!--Feign调用端（order）须引入负载均衡依赖，否则项目启动报错-->
        <!--对Feign调用负载均衡的支持-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-loadbalancer</artifactId>
        </dependency>
```
### 配置文件
```yaml
spring:
  datasource:
    url: jdbc:mysql://192.168.1.103:3306/jkeeper?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root
    password: 123456
seata: # Seata配置
  enabled: true
  service:
    vgroupMapping:
      jkeeper_tx_group: default
  tx-service-group: jkeeper_tx_group #自定义事务组名字,需要与Seata服务端application.yml中配置保持一致
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: 192.168.1.103:8848
      group: DEFAULT_GROUP
feign:
  okhttp:
    enabled: true
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000
        loggerLevel: basic
mybatis:
  mapperLocations: classpath:mapper/*.xml
logging:
  level:
    root: info
    com.kery.jkeeper: debug
```