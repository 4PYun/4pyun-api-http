package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.pyun.http.api.entity.ParkingPayment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingDetailResponse extends GatewayResponse {

    // 车牌号码
    private String plate;
    // 支付停车卡数字编号
    private String cardNo;
    // 支付停车卡物理ID, 停车场系统识别的
    private String cardId;
    // 车型, 参考：com.chinaroad.parking.api.enums.CarType
    private Short carType;
    // 车型类型说明
    private String carDesc;
    // 车型, 参考：com.chinaroad.parking.api.enums.VehicleType
    private Short vehicleType;
    // 停车流水, 标识具体某次停车事件, 需保证该停车场下唯一
    private String parkingSerial;
    // 入场时间, 格式: yyyyMMddHHmmss
    private String enterTime;
    // 车辆入场照片访问地址
    private String enterImage;
    // 车辆入场闸口标识
    private String enterGate;
    // 入场值班人员姓名
    private String enterSecurity;
    // 停车时长(单位秒)
    private Integer parkingTime;
    // 已优惠金额(单位分)
    private Integer freeValue;
    // 出场时间, 格式: yyyyMMddHHmmss
    private String leaveTime;
    // 车辆出场照片访问地址
    private String leaveImage;
    // 车辆出场闸口标识
    private String leaveGate;
    // 出场值班人员姓名
    private String leaveSecurity;
    // 总停车费用[应收](单位分)
    private Integer totalValue;

    // 支付记录列表(包括现金支付和移动支付)
    private List<ParkingPayment> payments;

    @Builder
    public ParkingDetailResponse(String resultCode, String message, String hint, String plate, String cardNo, String cardId, Short carType, String carDesc, Short vehicleType, String parkingSerial, String enterTime, String enterImage, String enterGate, String enterSecurity, Integer parkingTime, Integer freeValue, String leaveTime, String leaveImage, String leaveGate, String leaveSecurity, Integer totalValue, List<ParkingPayment> payments) {
        super(resultCode, message, hint);
        this.plate = plate;
        this.cardNo = cardNo;
        this.cardId = cardId;
        this.carType = carType;
        this.carDesc = carDesc;
        this.vehicleType = vehicleType;
        this.parkingSerial = parkingSerial;
        this.enterTime = enterTime;
        this.enterImage = enterImage;
        this.enterGate = enterGate;
        this.enterSecurity = enterSecurity;
        this.parkingTime = parkingTime;
        this.freeValue = freeValue;
        this.leaveTime = leaveTime;
        this.leaveImage = leaveImage;
        this.leaveGate = leaveGate;
        this.leaveSecurity = leaveSecurity;
        this.totalValue = totalValue;
        this.payments = payments;
    }
}
