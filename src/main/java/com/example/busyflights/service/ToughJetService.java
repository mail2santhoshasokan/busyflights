package com.example.busyflights.service;

import com.example.busyflights.domain.BusyFlight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ToughJetService {
    CompletableFuture<List<BusyFlight>> getFlightsFromToughJet(String from, String to, String outboundDate, String inboundDate, int numberOfAdults);
}
