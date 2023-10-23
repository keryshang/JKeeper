# MinIO对象存储使用手册
### 依赖
```xml
    <dependency>
        <groupId>io.minio</groupId>
        <artifactId>minio</artifactId>
    </dependency>
```
### 配置文件
```yaml
#MInIO分布式对象存储
minio:
  endpoint: http://192.168.1.106:9000 #MinIO服务所在地址，注意:9000才能进行api的操作,9001是图形化管理界面
  bucketName: jkeeper #存储桶名称
  accessKey:  #访问的key
  secretKey:  #访问的秘钥
```