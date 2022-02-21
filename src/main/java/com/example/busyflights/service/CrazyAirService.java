package com.example.busyflights.service;

import com.example.busyflights.domain.BusyFlight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface CrazyAirService {
    CompletableFuture<List<BusyFlight>> getFlightFromCrazyAir(String origin, String destination, String departureDate, String returnDate, int passengerCount);
}
