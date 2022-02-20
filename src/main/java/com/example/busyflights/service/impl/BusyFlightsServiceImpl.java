package com.example.busyflights.service.impl;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.service.BusyFlightsService;
import com.example.busyflights.service.CrazyAirService;
import com.example.busyflights.service.ToughJetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Autowired
    CrazyAirService crazyAirService;

    @Autowired
    ToughJetService toughJetService;

    @Override
    public List<BusyFlight> searchFlights(String origin, String destination, String departureDate, String returnDate, int numOfPassengers) {
        List<BusyFlight> crazyAirList = crazyAirService.getFlightFromCrazyAir(origin, destination, departureDate, returnDate, numOfPassengers);
        List<BusyFlight> toughJetList = toughJetService.getFlightsFromToughJet(origin, destination, departureDate, returnDate, numOfPassengers);
        List<BusyFlight> combinedList = Stream.of(crazyAirList, toughJetList)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        return combinedList;
    }
}
