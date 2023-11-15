# ELK(Elasticsearch+Logstash+Kibana)日志使用手册
## 依赖
```xml
        <!--集成logstash-->
        <dependency>
            <groupId>net.logstash.logback</groupId>
            <artifactId>logstash-logback-encoder</artifactId>
            <version>5.3</version>
        </dependency>
```
## 配置文件
```yaml
logstash:
  host: 192.168.1.106
logging:
  config: classpath:logback-spring.xml
```