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
public class ParkingDiscountCreateRequest extends GatewayRequest {

    /**
     * 停车场编号
     */
    private String parkUuid;
    /**
     * 停车流水, 标识具体某次停车事件, 需保证该停车场下唯一
     */
    private String parkingSerial;
    /**
     * 忽略停车状态派发时传递
     */
    private String plate;
    /**
     * 优惠券派发流水
     */
    private String grantSerial;
    /**
     * 优惠类型:1金额, 2时长, 3全免, 4不同计价券
     */
    private Short type;
    /**
     * 优惠金额
     * 当type=1时单位为分;
     * 当type=2时单位为分钟;
     * 当type=3时暂无定义;
     * 当type=4时为停车场计价规则ID
     */
    private Integer value;
    /**
     * 优惠给予原因, 例如:购物满300, 免费停车2小时
     */
    private String reason;
    /**
     * 当前派发优惠的商家名称
     */
    private String storeName;
    /**
     * 当前派发优惠的商家唯一标识
     */
    private String storeCode;
    /**
     * 优惠券减免规则ID, 用于配置减免是减免前面还是减免后面一般一个停车场配置相同
     */
    private String couponRule;
    /**
     * 不同计价券收费规则ID, 用于配置改优惠券后本次停车使用不同计价规则, 一般每种优惠券不同
     */
    private String chargeRule;
}
