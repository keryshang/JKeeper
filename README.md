# 🚀`JKeeper`

### `JKeeper` 致力于整合主流Java技术栈
<p>
    <a href="https://weibo.com/shangyanhui"><img src="https://img.shields.io/badge/Author-Kery-orange?logo=sinaweibo" alt="auther"></a>
    <a href="#公众号"><img src="https://img.shields.io/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-%E5%87%AF%E9%94%90%E5%90%8C%E5%AD%A6-orange?logo=wechat
" alt="公众号"></a>
    <a href="https://gitee.com/keryshang/jkeeper/blob/master/LICENSE"><img src="https://img.shields.io/badge/license-Apache%20License%202.0-parakeet?logo=apache" alt="license"></a>
</p>

### 🐯开发环境
- 语言：Java 8
- IDE(JAVA)： IntelliJ IDEA
- 依赖管理：Maven
- 镜像管理：Docker
- 数据库：MySQL5.7

### 🐳系统蓝图
![](https://pic.imgdb.cn/item/65211d9fc458853aef4e110c.jpg)
> https://www.processon.com/view/link/650da3215b73a44bd050dffb

### 🐶项目涉及技术栈 `[持续更新中]`
1. SpringBoot 2.7.0
2. SpringCloud 2021.0.3
3. Swagger-UI API接口文档
4. Logback 日志
5. Nacos 服务注册/配置中心
6. Redis 缓存数据库
7. RocketMQ 消息队列
8. SpringBootAdmin 系统监控
9. Mybatis 持久层管理
10. Feign 微服务Http远程调用
11. Sentinel 熔断限流
12. SpringCloudGateway 网关
13. SpringSecurity 安全框架
14. OAuth2.0 认证授权协议
15. JWT Token实现框架
16. Seata分布式事务
16. Coding...

### 🐼项目结构 `[持续更新中]`
```
Jkeeper
├─ JKeeper-Common
│
├─ JKeeper-Nacos
│
├─ JKeeper-Redis
│
├─ JKeeper-RocketMQ
│
├─ JKeeper-Monitor
│
├─ JKeeper-Mybatis-Generator
│
├─ JKeeper-Feign
│
├─ JKeeper-Sentinel
│
├─ JKeeper-Gateway
│
├─ JKeeper-Auth
│
├─ JKeeper-Seata
│
└─ 佛系Coding...

```
#### JKeeper-Common
该模块为公共模块，为其它项目提供公共组件支持  
[SwaggerUI使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-common/SwaggerUI%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Nacos
该模块主要涵盖：Nacos注册中心、Nacos配置中心、Logback日志、MinIO分布式对象存储的基本使用  
[Nacos使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-nacos/Nacos%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)  
[MinIO对象存储使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-nacos/MinIO%E5%AF%B9%E8%B1%A1%E5%AD%98%E5%82%A8%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Redis
该模块主要涵盖：Redis缓存数据库的基本使用  
[Redis使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-redis/Redis%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-RocketMQ
该模块主要涵盖：RocketMQ消息中间件的基本使用  
[RocketMQ使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-rockermq/RocketMQ%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Monitor
该模块主要涵盖：SpringBootAdmin服务监控、SpringSecurity安全框架的基本使用  
[SpringBootAdmin监控使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-monitor/SpringBootAdmin%E7%9B%91%E6%8E%A7%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Mybatis-Generator
该模块主要涵盖：Mybatis、MybatisGenerator的基本使用  
[Mybatis+Generator使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-mybatis-generator/Mybatis%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Feign
该模块主要涵盖：OpenFeign远程服务调用的基本使用  
[Feign使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-feign/Feign%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Sentinel
该模块主要涵盖：Sentinel服务熔断限流的基本使用  
[Sentinel使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-sentinel/Sentinel%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Gateway
该模块主要涵盖：SpringCloudGateway网关的基本使用  
[SpringCloudGateway使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-gateway/Gateway%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Auth
该模块主要涵盖：SpringSecurity安全框架、OAuth2.0认证授权、JWT token实现框架的基本使用  
[SpringSecurity+OAuth+JWT使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-auth/SpringSecurity+OAuth+JWT%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
#### JKeeper-Seata
该模块主要涵盖：Seata分布式事务的基本使用
[Seata使用手册](https://gitee.com/keryshang/jkeeper/blob/master/document/jkeeper-seata/Seata%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.md)
### 😎公众号
> 关注公众号 **凯锐同学**

<img src="https://pic.imgdb.cn/item/65138b5dc458853aef1f648f.jpg" alt="公众号" width="50%" />

![](https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F6c09c295-0cea-4dc9-892a-a3fa6f7febb7%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1697795519&t=50a92a69f9f0b9a16c0683bb7faa65a7)

### 🤝许可证

[Apache License 2.0](https://gitee.com/keryshang/jkeeper/blob/master/LICENSE)

Copyright (c) 2023-2023 Kery