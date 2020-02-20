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
public class ParkingPaymentRequest extends GatewayRequest {

    /**
     * 停车场编号
     */
    private String parkUuid;
    /**
     * 停车流水, 原客户端提交
     */
    private String parkingSerial;
    /**
     * 停车支付订单号, 原客户端提交
     */
    private String parkingOrder;
    /**
     * 通道编号ID, 付费时可传递触发开闸
     */
    private String gateId;
    /**
     * P云支付流水, 对账可用
     */
    private String paySerial;
    /**
     * 支付时间, 格式: yyyyMMddHHmmss
     */
    private String payTime;
    /**
     * 支付金额(单位分)
     */
    private Integer value;
    /**
     * 支付来源, 参考：com.chinaroad.parking.api.enums.PayOrigin
     */
    private Integer payOrigin;
    /**
     * 支付来源说明, 例如:P云
     */
    private String payOriginDesc;
}
