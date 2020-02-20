package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingRealtimeResponse extends GatewayResponse {

    /**
     * 停车场总车位数
     */
    private Integer total;
    /**
     * 当前场中车辆数量
     */
    private Integer parking;

    @Builder
    public ParkingRealtimeResponse(String resultCode, String message, String hint, Integer total, Integer parking) {
        super(resultCode, message, hint);
        this.total = total;
        this.parking = parking;
    }
}
