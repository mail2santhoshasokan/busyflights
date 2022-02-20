package com.example.busyflights.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusyFlight {

    @JsonProperty
    private String airline;

    @JsonProperty
    private String supplier;

    @JsonProperty
    private int fare;

    @JsonProperty
    private String departureAirportCode;

    @JsonProperty
    private String destinationAirportCode;

    @JsonProperty
    private String departureDate;

    @JsonProperty
    private String arrivalDate;
}
