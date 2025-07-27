package com.rest.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    int flightId;
    String flightName;
    String departure;
}
