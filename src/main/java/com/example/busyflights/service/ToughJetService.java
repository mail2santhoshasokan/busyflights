package com.example.busyflights.service;

import com.example.busyflights.domain.BusyFlight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToughJetService {
    List<BusyFlight> getFlightsFromToughJet(String from, String to, String outboundDate, String inboundDate, int numberOfAdults);
}
