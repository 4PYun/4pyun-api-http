package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingBillingResponse extends GatewayResponse {

    /**
     * 识别车牌号码
     */
    private String plate;
    /**
     * 无牌车获取订单返回本地的虚拟卡ID/虚拟车牌
     */
    private String cardId;
    /**
     * 停车流水, 标识具体某次停车事件, 需保证该停车场下唯一.
     */
    private String parkingSerial;
    /**
     * 停车支付订单号, 需保证该停车场下唯一.注:同一停车场内不可重复！
     */
    private String parkingOrder;
    /**
     * 入场时间, 格式 yyyyMMddHHmmss
     */
    private String enterTime;
    /**
     * 停车时长(单位秒)
     */
    private Integer parkingTime;
    /**
     * 总停车费用(单位分), 为用户从入场到现在获取订单时的总费用
     */
    private Integer totalValue;
    /**
     * 已优惠金额(单位分), 为停车场在当前停车费用时已经给予的优惠金额, 如果包涵优惠时间则该值为则free_value填写该时间
     * 等价的优惠金额+其他有效优惠金额
     */
    private Integer freeValue;
    /**
     * 已支付金额(单位分), 为当次停车用户已经支付的金额, 比如当用户先支付了一笔后, 超时未出场重新查询订单时须返回以支付金额
     */
    private Integer paidValue;
    /**
     * 应支付金额(单位分), 这里停车场系统需处理如果结果为负数的情况直接返回无需支付
     */
    private Integer payValue;
    /**
     * 入场免费时间(单位秒)
     */
    private Integer enterFreeTime;
    /**
     * 当前系统预留出场时间(单位秒)
     */
    private Integer bufferTime;
    /**
     * 车辆所在位置信息, 例如: B660
     */
    private String parkingNumber;
    /**
     * 锁车标识: 1已锁, 0未锁, -1不支持
     */
    private Short lockingStatus;
    /**
     * 自动支付状态: 1已开启, 0未开启
     */
    private Integer autopayStatus;

    @Builder
    public ParkingBillingResponse(String resultCode, String message, String hint, String plate, String cardId, String parkingSerial, String parkingOrder, String enterTime, Integer parkingTime, Integer totalValue, Integer freeValue, Integer paidValue, Integer payValue, Integer enterFreeTime, Integer bufferTime, String parkingNumber, Short lockingStatus, Integer autopayStatus) {
        super(resultCode, message, hint);
        this.plate = plate;
        this.cardId = cardId;
        this.parkingSerial = parkingSerial;
        this.parkingOrder = parkingOrder;
        this.enterTime = enterTime;
        this.parkingTime = parkingTime;
        this.totalValue = totalValue;
        this.freeValue = freeValue;
        this.paidValue = paidValue;
        this.payValue = payValue;
        this.enterFreeTime = enterFreeTime;
        this.bufferTime = bufferTime;
        this.parkingNumber = parkingNumber;
        this.lockingStatus = lockingStatus;
        this.autopayStatus = autopayStatus;
    }
}
