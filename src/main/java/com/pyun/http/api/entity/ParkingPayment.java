package com.pyun.http.api.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingPayment {

    // 停车支付订单号, 现金支付无需返回
    private String parkingOrder;
    // 平台支付流水, 现金支付无需返回
    private String paySerial;
    // 支付类型, 参考：com.chinaroad.parking.api.enums.PayType
    private Short payType;
    // 支付时间, 格式: yyyyMMddHHmmss
    private Short payTime;
    // 支付金额(单位分)
    private Integer value;
}
