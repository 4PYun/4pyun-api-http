package com.pyun.http.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingDirectEnterRequest extends GatewayRequest {

    /**
     * 停车场编号
     */
    private String parkUuid;
    /**
     * 用户通行证ID, 停车场可用作虚拟卡ID, 出场将传入
     */
    private String passport;
    /**
     * 通道编号ID
     */
    private String gateId;
}
