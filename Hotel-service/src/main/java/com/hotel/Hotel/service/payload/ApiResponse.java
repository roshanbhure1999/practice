package com.hotel.Hotel.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Setter
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
