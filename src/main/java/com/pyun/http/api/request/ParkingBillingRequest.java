package com.pyun.http.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingBillingRequest extends GatewayRequest {

    /**
     * 停车场编号, 由P云分配
     */
    private String parkUuid;
    /**
     * 支付车牌号
     */
    private String plate;
    /**
     * 支付停车卡物理ID
     */
    private String cardId;
    /**
     * 用户通行证ID, 无牌车传入
     */
    private String passport;
    /**
     * 通道编号ID, 无牌车付费时可传递触发开闸
     */
    private String gateId;

}
