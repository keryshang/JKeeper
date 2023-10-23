# Sentinel使用手册

### 依赖
```xml
        <!--对Sentinel的支持-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
        <!-- Sentinel使用Nacos配置存储 -->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
```
### 配置文件
```yaml
spring:
  cloud:
    sentinel:
      transport: # 配置 sentinel dashboard 地址
        dashboard: 192.168.1.106:8858
        #不写client-ip SentinelDashboard首页实时监控不展示
        client-ip: 192.168.1.1
        #Sentinel与控制台交互的端口
        host: 8719
      eager: true #服务启动直接建立心跳连接 
      datasource:
        flow: #限流 名称任意, 代表数据源
          nacos:
            server-addr: 192.168.1.106:8848
            dataId: jkeeper-sentinel-flow.json
            namespace: public
            groupId: DEFAULT_GROUP
            data-type: json
            # 规则类型: com.alibaba.cloud.sentinel.datasource.RuleType
            # flow：限流规则 degrade：熔断降级
            rule-type: flow
        degrade: #熔断
          nacos:
            server-addr: 192.168.1.106:8848
            dataId: jkeeper-sentinel-degrade.json
            namespace: public
            groupId: DEFAULT_GROUP
            data-type: json
            ruleType: degrade
logging:
  level:
    root: info
    com.kery.jkeeper: debug
```

### 流控规则

```json
[
  {
    "resource": "/test",    // 资源名
    "limitApp": "default",  // 针对来源，若为 default 则不区分调用来源
    "grade": 1,             // 限流阈值类型(1:QPS;0:并发线程数）
    "count": 1,             // 阈值
    "clusterMode": false,   // 是否是集群模式
    "controlBehavior": 0,   // 流控效果(0:快速失败;1:Warm Up(预热模式);2:排队等待)
    "strategy": 0,          // 流控模式(0:直接；1:关联;2:链路)
    "warmUpPeriodSec": 10,  // 预热时间（秒，预热模式需要此参数）
    "maxQueueingTimeMs": 500,// 超时时间（排队等待模式需要此参数）
    "refResource": ""       // 关联资源、入口资源(关联、链路模式)
  }
]
```
### 熔断降级规则
```json
[
  {
    "resource": "/test1",   // 资源名
    "limitApp": "default",
    "grade": 0,             // 熔断策略（0:慢调用比例，1:异常比率，2:异常计数）
    "count": 200,           // 最大RT、比例阈值、异常数
    "slowRatioThreshold": 0.2,// 慢调用比例阈值，仅慢调用比例模式有效（1.8.0 引入）
    "minRequestAmount": 5,  // 最小请求数
    "statIntervalMs": 1000,// 当单位统计时长(类中默认1000)
    "timeWindow": 10    // 熔断时长
  }
]

```
- 注：配置时需要将注释删除，否则不生效
- 其他规则详见Sentinel官方文档
>http://sentinelguard.io/zh-cn/docs/basic-api-resource-rule.html

