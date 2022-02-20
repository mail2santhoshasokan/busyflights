package com.example.busyflights.service;

import com.example.busyflights.domain.BusyFlight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrazyAirService {
    List<BusyFlight> getFlightFromCrazyAir(String origin, String destination, String departureDate, String returnDate, int passengerCount);
}
