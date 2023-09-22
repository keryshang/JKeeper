# Redis使用手册
### 依赖
```xml
    <!-- Redis-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
```
### 配置文件
```yaml
spring:
  redis:
    host:               # Redis服务器地址
    database: 0         # Redis数据库索引（默认为0）
    port: 6379          # Redis服务器连接端口
    password:           # Redis服务器连接密码（默认为空）
    timeout: 300ms      # 连接超时时间（毫秒）
```