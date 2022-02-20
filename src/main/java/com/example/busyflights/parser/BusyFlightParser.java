package com.example.busyflights.parser;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.domain.CrazyAir;
import com.example.busyflights.domain.ToughJet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusyFlightParser {

    public List<BusyFlight> parseCrazyAirFlights(List<CrazyAir> crazyAirList){
        BusyFlight busyFlight;
        List<BusyFlight> busyFlightList = new ArrayList<>();
        for (int i=0;i<crazyAirList.size();i++){
            CrazyAir crazyAir = crazyAirList.get(i);
            busyFlight = new BusyFlight();
            busyFlight.setAirline(crazyAir.getAirline());
            busyFlight.setSupplier("CrazyAir");
            busyFlight.setFare(Integer.parseInt(crazyAir.getPrice()));
            busyFlight.setDepartureAirportCode(crazyAir.getDepartureAirportCode());
            busyFlight.setDestinationAirportCode(crazyAir.getDestinationAirportCode());
            busyFlight.setDepartureDate(crazyAir.getDepartureDate());
            busyFlight.setArrivalDate(crazyAir.getArrivalDate());

            busyFlightList.add(busyFlight);
        }
        return busyFlightList;
    }

    public List<BusyFlight> parseToughJetFlights(List<ToughJet> toughJetList){
        BusyFlight busyFlight;
        List<BusyFlight> busyFlightList = new ArrayList<>();
        for (int i=0;i<toughJetList.size();i++){
            ToughJet toughJet = toughJetList.get(i);
            busyFlight = new BusyFlight();
            busyFlight.setAirline(toughJet.getCarrier());
            busyFlight.setSupplier("ToughJet");
            busyFlight.setFare(Integer.parseInt(toughJet.getBasePrice()));
            busyFlight.setDepartureAirportCode(toughJet.getDepartureAirportName());
            busyFlight.setDestinationAirportCode(toughJet.getArrivalAirportName());
            busyFlight.setDepartureDate(toughJet.getOutboundDateTime());
            busyFlight.setArrivalDate(toughJet.getInboundDateTime());

            busyFlightList.add(busyFlight);
        }
        return busyFlightList;
    }
}
