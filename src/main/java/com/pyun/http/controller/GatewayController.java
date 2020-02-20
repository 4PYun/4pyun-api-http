package com.pyun.http.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyun.http.api.consts.ResultCode;
import com.pyun.http.api.consts.ServiceName;
import com.pyun.http.api.request.*;
import com.pyun.http.api.response.GatewayResponse;
import com.pyun.http.exception.APIRemoteException;
import com.pyun.http.exception.AccessDenyException;
import com.pyun.http.security.SecurityProvider;
import com.pyun.http.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
@RestController
public class GatewayController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProvider securityProvider;
    @Autowired
    private ParkingService parkingService;

    @PostMapping("gateway/1.0/dispatch")
    public GatewayResponse dispatch(@RequestBody String body) throws JsonProcessingException {
        try {
            // 解析请求参数
            Map<String, String> args = objectMapper.readValue(body, new TypeReference<TreeMap<String, String>>() {});

            // 检查参数...
            String service = args.getOrDefault("service", "");
            if (StringUtils.isEmpty(service)) throw new IllegalArgumentException("请求参数`service`缺失!");
            // 检查签名
            securityProvider.verifyRequest(args);

            // 转发请求
            if (ServiceName.ParkingBilling.equals(service)) {
                // 获取停⻋订单
                return parkingService.billing(objectMapper.readValue(body, ParkingBillingRequest.class));
            } else if (ServiceName.ParkingPayment.equals(service)) {
                // 订单⽀支付结果通知
                return parkingService.payment(objectMapper.readValue(body, ParkingPaymentRequest.class));
            } else if (ServiceName.ParkingDirectEnter.equals(service)) {
                // 无牌⻋⼊场
                return parkingService.directEnter(objectMapper.readValue(body, ParkingDirectEnterRequest.class));
            } else if (ServiceName.ParkingVIPQuery.equals(service)) {
                // 车辆信息查询
                return parkingService.vipQuery(objectMapper.readValue(body, ParkingVIPQueryRequest.class));
            } else if (ServiceName.ParkingVIPRenewal.equals(service)) {
                // 车辆续费通知
                return parkingService.vipRenewal(objectMapper.readValue(body, ParkingVIPRenewalRequest.class));
            } else if (ServiceName.ParkingDiscountCreate.equals(service)) {
                // 车辆续费通知
                return parkingService.discountCreate(objectMapper.readValue(body, ParkingDiscountCreateRequest.class));
            } else if (ServiceName.ParkingDiscountDestroy.equals(service)) {
                // 车辆续费通知
                return parkingService.discountDestroy(objectMapper.readValue(body, ParkingDiscountDestroyRequest.class));
            } else if (ServiceName.ParkingPrepaySYNC.equals(service)) {
                // 车辆无感支付权限开关
                return parkingService.prepay(objectMapper.readValue(body, ParkingPrepayRequest.class));
            } else if (ServiceName.ParkingRealtime.equals(service)) {
                // 车辆无感支付权限开关
                return parkingService.realtime(objectMapper.readValue(body, ParkingRealtimeRequest.class));
            } else if (ServiceName.ParkingDetail.equals(service)) {
                // 车辆无感支付权限开关
                return parkingService.parkingDetail(objectMapper.readValue(body, ParkingDetailRequest.class));
            } else {
                // 默认策略
                return GatewayResponse.create()
                        .resultCode(ResultCode.SERVICE_UNAVAILABLE)
                        .message("接口尚未实现")
                        .hint(service)
                        .build();
            }
        } catch (IllegalArgumentException e) {
            return GatewayResponse.create()
                    .resultCode(ResultCode.ILLEGAL_ARGUMENT)
                    .message("请求参数错误")
                    .hint(e.getMessage())
                    .build();
        } catch (AccessDenyException e) {
            return GatewayResponse.create()
                    .resultCode(ResultCode.ACCESS_DENY)
                    .message(e.getMessage())
                    .hint(e.getHint())
                    .build();
        } catch (APIRemoteException e) {
            return GatewayResponse.create()
                    .resultCode(e.getCode())
                    .message(e.getMessage())
                    .hint(e.getHint())
                    .build();
        } catch (Exception e) {
            return GatewayResponse.create()
                    .resultCode(ResultCode.INTERNAL_ERROR)
                    .message("接口内部处理异常")
                    .hint(e.getMessage())
                    .build();
        }
    }

}
