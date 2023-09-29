# SpringSecurity+OAuth2+JWT原理

## 原理解释
### 一、SpringSecurity  
Security是spring提供的一个高度自定义的安全框架，为系统提供了安全访问控制功能。简化了认证授权及系统安全管理。Security使用了责任链的设计模式，他提供了一个非常长的过滤器链完成完成认证、授权、鉴权的相关操作。  
### 二、OAuth2.0  
OAuth是一套关于认证授权的协议，是一种规范，Spring-Security-OAuth是对OAuth规范的一种实现。OAuth保证了访问资源的安全性以及灵活性。他允许用户不把某系统的账号密码提供给第三方，第三方就能访问到此用户该系统上的信息，使第三方应用可以更安全的访问资源。  
OAuth在客户端与资源服务之间设置了一个授权层。使客户端不能直接访问资源服务，而需要客户端经过用户同意授权之后在授权层拿到令牌token，使用token访问资源服务。授权层在颁发token的时候可以指定token的授权范围以及有效时间。使用token只能访问规定的范围内的资源。  
流程图：![](https://pic.imgdb.cn/item/6514fc00c458853aef99b85d.png)
（A）客户端请求用户授权  
（B）用户同意客户端的授权请求  
（C）客户端使用用户授权请求授权服务器  
（D）授权服务器延华智能成功之后颁发令牌access token  
（E）客户端使用access token请求资源服务  
（F）资源服务器校验token做出响应  

对于客户端的授权流程OAuth2.0定义了四种授权模式
1. 授权码模式  
2. 隐式模式
3. 密码模式
4. 客户端模式
#### 授权码模式
授权码模式是最严密最复杂最安全的授权模式。
![](https://pic.imgdb.cn/item/6514fd8dc458853aef9ab87c.png)
前提：

需要在授权服务器上提前定义好客户端的 客户端ID（client_id） 、 客户端秘钥（client_secret）、回调地址（redirect_uri）、客户端的授权模式、作用域、资源ID等。

2、客户端请求授权服务器授权时需要携带client_id、client_secret、response_type http://localhost:8080/oauth/authorize?client_id=c123456&client_secret=c123456&response_type=code

3、授权服务器返回登录页让用户登录，登录成功返回授权页，让用户给客户端授权

5、用户给与授权之后，授权服务器调用回调地址，返回授权码 http://localhost:9001/callback?code=j0vvGf

6、客户端使用授权码换取token，http://localhost:8080/oauth/token
token校验有两种方式：1、配置授权服务器的token校验的端口，2、配置和授权服务器一样的TokenStore
#### 隐式模式
用户登录授权服务器并对客户端授权，授权服务器直接返回token，省略了授权码的过程。
![](https://pic.imgdb.cn/item/6514fda8c458853aef9ad8dc.png)
前提：

需要在授权服务器上提前定义好客户端的 客户端ID（client_id） 、 客户端秘钥（client_secret）、回调地址（redirect_uri）、客户端的授权模式、作用域、资源ID等。

2、客户端请求授权服务器授权时需要携带client_id、response_type

http://localhost:8080/oauth/authorize?client_id=client-a&response_type=token

3、授权服务器返回登录页让用户登录，登录成功返回授权页，让用户给客户端授权

5、用户给与授权之后，授权服务器调用回调地址，返回token

http://localhost:9001/callback#access_token=ede88421-5703-4365-a72e-b5f0b6101704&token_type=bearer&expires_in=42841&scope=all

token校验有两种方式：1、配置授权服务器的token校验的端口，2、配置和授权服务器一样的TokenStore
#### 密码模式
密码模式中需要用户提供自己的账号密码给客户端，客户端使用用户的账号密码和client_id client_secret去授权服务器请求token
![](https://pic.imgdb.cn/item/6514fdb8c458853aef9adb4f.png)
#### 客户端模式
客户端以自己的名义，而不是以用户的名义 去授权服务器申请token
![](https://pic.imgdb.cn/item/6514fdc6c458853aef9add02.png)

### 三、JTW  
JWT：JSON Web Token是一种具体的Token实现框架，是基于token的认证协议的实现。   
JWT主要用来生成token，验证token合法性，是否过期，获取用户信息，token中包含用户信息。

### 总结
OAuth2.0是规范，使用时是引入了OAuth2.0的规范。

JWT是token的实现，做token的生成以及校验。

Security本身是一套完整的认证和授权解决方案，他是一条很长的过滤器链，使用OAuth和JWT需要在过滤器链中定义OAuth和JWT的具体实现。

前后端分离的系统，只需要实现token，做token的颁发和校验。JWT是token的一种实现方式。

系统需要给第三方系统做授权，就需要实现OAuth。

JWT对token的实现可以通过解密获取用户信息以及权限信息，简化OAuth的校验流程。