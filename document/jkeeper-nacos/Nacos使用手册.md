# Nacos使用手册
### Nacos配置模板
```yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.1.103:8848
        username: 
        password: 
        namespace: #默认是public
        group: #默认是DEFAULT_GROUP
      config:
        server-addr: 192.168.1.103:8848
        username: nacos
        password: nacos
        namespace: #默认是public
        group: #默认是DEFAULT_GROUP
        file-extension: yaml
```
### 自定义扩展DataId
Jkeeper-Nacos配置中心使用的是默认DataId模式，Nacos还支持自定义扩展的DataId模式。通过自定义扩展的 Data Id 配置，既可以解决多个应用间配置共享的问题，又可以支持一个应用有多个配置文件。  
#### 自定义 Data Id 的配置有两种方式：
- spring.cloud.nacos.config.sharedConfigs：支持共享的 DataId。比如：不同工程的通用配置。
- spring.cloud.nacos.config.extensionConfigs：支持扩展的 DataId。比如：一个应用多个 DataId 的配置

```yaml
spring:
  cloud:
    nacos:
      server-addr: localhost:8848
      username: nacos
      password: nacos
      config:
        #namespace: #默认是public
        file-extension: yaml
        shared-configs:
          - data-id: app.service.common1.yaml
            refresh: true
            #group:  #默认是DEFAULT-GROUP
          - data-id: app.service.common2.yaml
            refresh: true
        extension-configs:
          - data-id: app.service1.common.yaml
            refresh: true
```
#### 配置的优先级
1. spring.application.name−{profile}.${file-extension:properties}
2. spring.application.name.{file-extension:properties}
3. ${spring.application.name}
4. extensionConfigs `(下标越大优先级就越大)`
5. sharedConfigs `(下标越大优先级就越大)`