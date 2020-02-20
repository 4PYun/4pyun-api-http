package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingDiscountDestroyResponse extends GatewayResponse {

    @Builder
    public ParkingDiscountDestroyResponse(String resultCode, String message, String hint) {
        super(resultCode, message, hint);
    }

}
