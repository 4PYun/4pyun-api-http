package com.pyun.http.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GatewayRequest {

    // 服务名称
    private String service;
    // 接口版本
    private String version;
    // 编码
    private String charset;
    // 请求签名
    private String sign;

}
