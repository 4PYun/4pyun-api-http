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
public class ParkingPrepayRequest extends GatewayRequest {

    /**
     * 停车场编号
     */
    private String parkUuid;
    /**
     * 停车流水, 原客户端提交
     */
    private String parkingSerial;
    /**
     * 支付来源, 参考：com.chinaroad.parking.api.enums.PayOrigin
     */
    private Integer payOrigin;
    /**
     * 支付来源说明, 例如:P云
     */
    private String payOriginDesc;
    /**
     * 当前用户可用信用额度(分), credits大于零则开启自动支付
     */
    private Integer credits;
    /**
     * 锁定车辆, 参考：com.chinaroad.parking.api.enums.LockType
     */
    private Short locking;
}
