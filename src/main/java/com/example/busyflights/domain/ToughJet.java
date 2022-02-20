package com.example.busyflights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ToughJet {

    @JsonProperty
    private String carrier;

    @JsonProperty
    private String basePrice;

    @JsonProperty
    private String tax;

    @JsonProperty
    private String discount;

    @JsonProperty
    private String departureAirportName;

    @JsonProperty
    private String arrivalAirportName;

    @JsonProperty
    private String outboundDateTime;

    @JsonProperty
    private String inboundDateTime;
}
