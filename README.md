# PYun HTTP 接入

合作方可参考该项目开发自己的HTTP网关完成P云的对接, 对接协议文档

https://doc.4pyun.com/parking/guideline/http.html

## 说明

- `com.pyun.http.service.ParkingService` 中的方法是最终需要实现的业务分别对应目前文档里面的功能;
- `com.pyun.http.security.SecurityProvider` 需要在这里实现车场的密钥配置，从而实现不同车场不同密钥。

关于返回状态码`result_code`具体返回值参考文档中的定义, 不必一定在`com.pyun.http.api.consts.ResultCode`中定义。

## 接口地址:
```bash
http://127.0.0.1:8080/gateway/1.0/dispatch
```