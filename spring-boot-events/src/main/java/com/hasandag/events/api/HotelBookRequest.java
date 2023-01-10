package com.hasandag.events.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class HotelBookRequest {
    private String userId;
    private String hotelId;
}
