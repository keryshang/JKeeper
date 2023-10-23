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
    url: jdbc:mysql://192.168.1.106:3306/jkeeper?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
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
      server-addr: 192.168.1.106:8848
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
### 测试操作手册
该Demo分为三个模块，账户、订单、库存。创建订单时，须同时对账户余额和库存进行相应扣减操作

seata-account 端口号：8091  
seata-order 端口号：8092  
seata-storage 端口号：8093  
项目启动之后，查看Seata日志，三个服务均成功注册到Seata
![](https://pic.imgdb.cn/item/6535d272c458853aef2754e9.jpg)
创建订单测试：http://localhost:8092/order/create
![](https://pic.imgdb.cn/item/6535d1f2c458853aef26456f.jpg)
![](https://pic.imgdb.cn/item/6535d208c458853aef2676fb.jpg)
查看数据库，订单已经生成，库存和账户均进行了相应的扣减
![](https://pic.imgdb.cn/item/6535d572c458853aef2e5111.jpg)
接下来测试异常情况，在账户扣减模块模拟一个扣减超时异常
![](https://pic.imgdb.cn/item/6535d2fac458853aef2874fd.jpg)
重新调用订单创建接口，使用debug模式，当异常产生后查看seata后台可查询到当前执行的事务信息
![](https://pic.imgdb.cn/item/6535d1c9c458853aef25f594.jpg)
![](https://pic.imgdb.cn/item/6535d227c458853aef26b6aa.jpg)
该请求执行完毕后该事务由于异常进行了回滚操作，查看订单数据库，此时并没有新的订单生成，同事库存和账户也没有进行任何扣减操作，查看Seata后台，由于该事务已经执行了回归操作，因此已经查询不到该事务的信息。