package com.rest.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String detail;
}
