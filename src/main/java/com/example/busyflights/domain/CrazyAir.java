package com.example.busyflights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CrazyAir {

    @JsonProperty
    private String airline;

    @JsonProperty
    private String price;

    @JsonProperty
    private String cabinClass;

    @JsonProperty
    private String departureAirportCode;

    @Column
    private String destinationAirportCode;

    @JsonProperty
    private String departureDate;

    @JsonProperty
    private String arrivalDate;

}
