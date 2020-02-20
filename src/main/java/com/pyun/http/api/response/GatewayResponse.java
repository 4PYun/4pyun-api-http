package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GatewayResponse {

    /**
     * 状态码
     */
    private String resultCode;
    /**
     * 状态码处理描述, 如:返回错误信息
     */
    private String message;
    /**
     * 提示处理说明
     */
    private String hint;

    @Builder(builderMethodName = "create")
    public GatewayResponse(String resultCode, String message, String hint) {
        this.resultCode = resultCode;
        this.message = message;
        this.hint = hint;
    }

}
