package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.pyun.http.api.entity.ParkingVIP;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingVIPQueryResponse extends GatewayResponse {

    /**
     * 贵宾集合, 即月卡/次卡/储值卡中的一种
     */
    private List<ParkingVIP> vips;

    @Builder
    public ParkingVIPQueryResponse(String resultCode, String message, String hint, List<ParkingVIP> vips) {
        super(resultCode, message, hint);
        this.vips = vips;
    }
}
