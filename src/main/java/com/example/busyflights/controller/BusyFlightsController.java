package com.example.busyflights.controller;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.service.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/busyFlight")
public class BusyFlightsController {

    @Autowired
    BusyFlightsService busyFlightsService;

    @GetMapping("/flightSchedules")
    public ResponseEntity<List<BusyFlight>> searchFlights(
            @RequestParam(name = "origin") String origin,
            @RequestParam(name = "destination") String destination,
            @RequestParam(name = "departureDate") String departureDate,
            @RequestParam(name = "returnDate") String returnDate,
            @RequestParam(name = "passengerCount") int passengerCount) {
        return ResponseEntity.ok().body(busyFlightsService.searchFlights(origin, destination, departureDate, returnDate, passengerCount));
    }
}
