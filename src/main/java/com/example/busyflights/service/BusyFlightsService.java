package com.example.busyflights.service;

import com.example.busyflights.domain.BusyFlight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusyFlightsService {
    List<BusyFlight> searchFlights(String origin, String destination, String departureDate, String returnDate, int numOfPassengers);
}
