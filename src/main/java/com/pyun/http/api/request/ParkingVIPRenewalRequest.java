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
public class ParkingVIPRenewalRequest extends GatewayRequest {

    // 停车场编号
    private String parkUuid;
    // 车牌号码
    private String plate;
    // 停车卡编号(若存在)
    private String cardNo;
    // 停车卡ID(若存在)
    private String cardId;
    // 续费时间, 格式: yyyyMMddHHmmss
    private String payTime;
    // 支付流水, 用于对账
    private String paySerial;
    // 客户支付金额, 单位分
    private Integer payValue;
    // 贵宾类型, 参考：com.chinaroad.parking.api.enums.VIPType
    private Short type;
    // 续费金额:
    // 储值: 为余额, 单位分;
    // 储次:为剩余次数;
    // 储天:为剩余天数;
    // 月卡/年卡/季度卡:为剩余天数
    private Integer value;
    // 续费数量:
    // 储值: 续费金额, 单位分;
    // 储次:续费次数;
    // 储天:续费天数;
    // 月卡:续费月数;
    // 年卡:续费年数;
    // 季度卡:续费季度数
    private Integer quantity;
}
