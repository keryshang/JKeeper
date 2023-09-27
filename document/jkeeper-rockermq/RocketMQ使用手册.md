# RocketMQ使用手册
### 依赖
```xml
    <!--对RocketMQ的支持-->
    <dependency>
        <groupId>org.apache.rocketmq</groupId>
        <artifactId>rocketmq-spring-boot-starter</artifactId>
    </dependency>
```
### 配置文件
```yaml
rocketmq:
  name-server: #ip:9876
  consumer:
    group: jkeeper_group
    # 一次拉取消息最大值，注意是拉取消息的最大值而非消费最大值
    pull-batch-size: 10
  producer:
    # 发送同一类消息的设置为同一个group，保证唯一
    group: jkeeper_group
    # 发送消息超时时间，默认3000
    sendMessageTimeout: 10000
    # 发送消息失败重试次数，默认2
    retryTimesWhenSendFailed: 2
    # 异步消息重试此处，默认2
    retryTimesWhenSendAsyncFailed: 2
    # 消息最大长度，默认1024 * 1024 * 4(默认4M)
    maxMessageSize: 4096
    # 压缩消息阈值，默认4k(1024 * 4)
    compressMessageBodyThreshold: 4096
    # 是否在内部发送失败时重试另一个broker，默认false
    retryNextServer: false
```
### 消息消费模式
- MessageModel.CLUSTERING - 集群消费：  
使用集群消费模式时，MQ 认为任意一条消息只需要被集群（group）内的任意一个消费者处理即可。
- MessageModel.BROADCASTING - 广播消费：  
  使用广播消费模式时，MQ 会将每条消息推送给集群内所有消费者，保证消息至少被每个消费者消费一次。
```java
    //默认为集群消费模式，无需指定messageModel， enableMsgTrace = true为开启消息消费轨迹
    @Service
    @RocketMQMessageListener(topic = "TEST_TOPIC", consumerGroup = "jkeeper_group", enableMsgTrace = true)
    public class Consumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String str) {
            log.info("监听到消息：str={}", str);
        }
    }
    //广播消费模式
    @Service
    @RocketMQMessageListener(messageModel = MessageModel.BROADCASTING, topic = "TEST_TOPIC", consumerGroup = "jkeeper_group", enableMsgTrace = true)
    public class Consumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String str) {
            log.info("监听到消息：str={}", str);
        }
    }

```