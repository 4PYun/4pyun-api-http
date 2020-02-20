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
public class ParkingVIP {

    // 客户姓名
    private String realname;
    // 车牌号码
    private String plate;
    // 停车卡编号(若存在)
    private String cardNo;
    // 停车卡ID(若存在)
    private String cardId;
    // 收费标准类型标识; 例如:MON_A、12
    private String chargeType;
    // 当前贵宾收费标准描述;例如: 月卡B
    private String chargeDesc;
    // 收费单价, 单位分
    private Integer chargePrice;
    // 绑定的手机号
    private String mobile;
    // 绑定的身份证号
    private String idCard;
    // 办理时间, 格式: yyyyMMdd
    private String createTime;
    // 过期时间, 格式: yyyyMMdd
    private String expireTime;
    // 贵宾类型, 参考：com.chinaroad.parking.api.enums.VIPType
    private Short type;
    // 当前余额:
    // 储值: 为余额, 单位分;
    // 储次:为剩余次数;
    // 储天:为剩余天数;
    // 月卡/年卡/季度卡:为剩余天数
    private Integer balance;
}
