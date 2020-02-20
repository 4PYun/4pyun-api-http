package com.pyun.http.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParkingPaymentResponse extends GatewayResponse {

    @Builder
    public ParkingPaymentResponse(String resultCode, String message, String hint) {
        super(resultCode, message, hint);
    }

}
