package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingDirectEnterResponse extends GatewayResponse {

    /**
     * 入场时间, 格式:yyyyMMddHHmmss
     */
    private String enterTime;
    /**
     * 入口名称
     */
    private String enterGate;
    /**
     * 停车时长, 单位s
     */
    private Integer parkingTime;
    /**
     * 停车流水
     */
    private String parkingSerial;

    @Builder
    public ParkingDirectEnterResponse(String resultCode, String message, String hint, String enterTime, String enterGate, Integer parkingTime, String parkingSerial) {
        super(resultCode, message, hint);
        this.enterTime = enterTime;
        this.enterGate = enterGate;
        this.parkingTime = parkingTime;
        this.parkingSerial = parkingSerial;
    }
}
