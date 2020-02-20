package com.pyun.http.api.consts;

public interface ServiceName {

    /**
     * 获取停⻋订单
     */
    String ParkingBilling = "service.parking.payment.billing";
    /**
     * 订单⽀支付结果通知
     */
    String ParkingPayment = "service.parking.payment.result";
    /**
     * 无牌⻋⼊场
     */
    String ParkingDirectEnter = "service.parking.direct.enter";
    /**
     * 车辆信息查询
     */
    String ParkingVIPQuery = "service.parking.vip.query";
    /**
     * 车辆续费通知
     */
    String ParkingVIPRenewal = "service.parking.vip.renewal";
    /**
     * 优惠券下发
     */
    String ParkingDiscountCreate = "service.parking.discount.create";
    /**
     * 优惠券撤销
     */
    String ParkingDiscountDestroy = "service.parking.discount.destroy";
    /**
     * 车辆无感支付权限开关
     */
    String ParkingPrepaySYNC = "service.parking.vip";
    /**
     * 获取车场实时车位
     */
    String ParkingRealtime = "service.parking.realtime";
    /**
     * 获取停车记录详情
     */
    String ParkingDetail = "service.parking.detail";

}
