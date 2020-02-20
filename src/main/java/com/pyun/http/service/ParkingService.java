package com.pyun.http.service;

import com.pyun.http.api.consts.ParkingVIPType;
import com.pyun.http.api.entity.ParkingVIP;
import com.pyun.http.api.request.*;
import com.pyun.http.api.response.*;
import com.pyun.http.exception.APIRemoteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class ParkingService {

    /**
     * 4.1 获取停车订单
     * 协议说明:
     * 当用户在P云场时获取停车订单时, P云将发送该协议请求到停车场系统, 通过车牌号/停车卡ID获取停车支付订单;
     * 付费入场
     * - 当付费入场当前接口传递参数gate_id对应车场系统通道类型为入口, 厂商自行判断是否允许付费入场, 若不允许直接返回没有订单或返回错误信息即可; 反之直接返回付费入场的费用。
     * - 若为无牌车入场, 虚拟车牌会在支付结果同步时传递给车场系统。
     *
     * 时段月卡/多车共位
     * 在多月共位/时段月卡的场景, 可返回car_type, 用于当非临时车辆时(car_type!=1), 前端可选择跳转固定车续费或直接缴临停费用。
     *
     * @param request
     * @return
     */
    public ParkingBillingResponse billing(ParkingBillingRequest request) throws APIRemoteException {
        // TODO
        return ParkingBillingResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .plate("川A12345")
                .parkingSerial("123")
                .totalValue(100)
                .freeValue(0)
                .paidValue(0)
                .payValue(100)
                .build();
    }

    /**
     * 4.2 订单支付结果通知
     * 协议说明:
     * 当用户完成支付后, P云将主动发起支付结果通知, 通知客户端订单支付结果.
     *
     * 注:
     * - 为保证通知正常处理, 服务端可能发起多次支付结果通知, 客户端需做好去重逻辑.
     * - 对于已经受到支付结果通知的订单, 应应答通知成功, 已告知服务端不必继续通知.
     *
     * @param request
     * @return
     */
    public ParkingPaymentResponse payment(ParkingPaymentRequest request) throws APIRemoteException {
        // TODO
        return ParkingPaymentResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 4.3 停车场实时数据(停车位等)拉取
     * 协议说明:
     *
     * P云将以固定频率调用该接口获取总停车位和场中车辆等数据的获取.
     * @param request
     * @return
     */
    public ParkingRealtimeResponse realtime(ParkingRealtimeRequest request) throws APIRemoteException {
        // TODO
        return ParkingRealtimeResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .total(100)
                .parking(10)
                .build();
    }

    /**
     * 4.5 车辆自动支付权限开关
     * 协议说明:
     *
     * 当用户满足自动支付条件时, P云主动向停车场系统发起设置车辆自动支付权限,
     * 停车场可以根据credits在车场离场时选择是否触发主动扣费实现无感停车。
     *
     * @param request
     * @return
     */
    public ParkingPrepayResponse prepay(ParkingPrepayRequest request) throws APIRemoteException {
        // TODO
        return ParkingPrepayResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 4.7 获取停车记录详情
     * 协议说明:
     *
     * 该协议主要用于处理异常订单, 方便P云拉取订单详情, 已方便对账以及异常订单处理.
     *
     * 注:最近出入场车辆查询(4.4)也返回相应停车信息以及支付信息.
     * @param request
     * @return
     */
    public ParkingDetailResponse parkingDetail(ParkingDetailRequest request) throws APIRemoteException {
        // TODO
        return ParkingDetailResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 4.8 无牌车入场
     * 说明:
     *
     * 为实现无人值守, 针对无牌车通过扫码后平台会调用该接口完成入场开闸.
     * 若短时间重复调用该接口则不重复写入入场记录.
     * @param request
     * @return
     */
    public ParkingDirectEnterResponse directEnter(ParkingDirectEnterRequest request) throws APIRemoteException {
        // TODO
        return ParkingDirectEnterResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 5.1 发放商户优惠券
     * 协议说明:
     *
     * P云通过和停车场系统完成优惠对接, 将停车场优惠券实现纯电子化.
     * 无论用户移动支付或现金支付, 停车场系统均可读取到本次停车关联的停车优惠并自动抵扣停车费.
     * @param request
     * @return
     */
    public ParkingDiscountCreateResponse discountCreate(ParkingDiscountCreateRequest request) throws APIRemoteException {
        // TODO
        return ParkingDiscountCreateResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 5.2 撤销商户优惠
     * 协议说明:
     * 用于在优惠发放错误是, 清空指定停车记录已发放的商户优惠.
     *
     * 是否是在特定时间内才可以撤回还是任意时间都能撤回？ 这样有点不合理, 如果车主离开商场了, 出场时发现优惠券没了, 这时候会引起争议的;嗯, 那是否限制发出去后10分钟后不可撤销.
     * 如果发出去5分钟内车主离场了, 但是6分钟后才发觉发错了, 这时候撤不回怎么办？ 如果发现已经出场, 那么你们返回无法撤销, 车辆已出场.
     * @param request
     * @return
     */
    public ParkingDiscountDestroyResponse discountDestroy(ParkingDiscountDestroyRequest request) throws APIRemoteException {
        // TODO
        return ParkingDiscountDestroyResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

    /**
     * 6.1 车辆信息查询
     * 协议说明:
     *
     * P云发起向停车场, 查询指定车辆固定车信息, 停车场返回对应车牌/客户信息。
     * @param request
     * @return
     */
    public ParkingVIPQueryResponse vipQuery(ParkingVIPQueryRequest request) throws APIRemoteException {
        // TODO
        List<ParkingVIP> vipList = new LinkedList<>();
        vipList.add(ParkingVIP.builder()
                .realname("姓名")
                .plate("川A12345")
                .type(ParkingVIPType.Month)
                .chargePrice(10000)
                .chargeDesc("月卡A")
                .chargeType("MON_A")
                .balance(100)
                .build());

        return ParkingVIPQueryResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .vips(vipList)
                .build();
    }

    /**
     * 6.2 车辆续费通知
     * 协议说明: P云发起请求, 对固定车进行充值续费。
     * @param request
     * @return
     */
    public ParkingVIPRenewalResponse vipRenewal(ParkingVIPRenewalRequest request) throws APIRemoteException {
        // TODO
        return ParkingVIPRenewalResponse.builder()
                .resultCode("1001")
                .message("处理成功")
                .build();
    }

}
