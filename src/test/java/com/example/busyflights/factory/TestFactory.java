package com.example.busyflights.factory;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.domain.CrazyAir;
import com.example.busyflights.domain.ToughJet;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestFactory {

    public static List<BusyFlight> combinedFlightList() {

        BusyFlight crazyAir = new BusyFlight();
        crazyAir.setAirline("BritishAirways");
        crazyAir.setSupplier("CrazyAir");
        crazyAir.setFare(350);
        crazyAir.setDepartureAirportCode("LHR");
        crazyAir.setDestinationAirportCode("COK");
        crazyAir.setDepartureDate(LocalDateTime.now().toString());
        crazyAir.setArrivalDate(LocalDateTime.now().toString());

        BusyFlight toughJet = new BusyFlight();
        toughJet.setAirline("Lufthansa");
        toughJet.setSupplier("ToughJet");
        toughJet.setFare(350);
        toughJet.setDepartureAirportCode("LHR");
        toughJet.setDestinationAirportCode("COK");
        toughJet.setDepartureDate(LocalDateTime.now().toString());
        toughJet.setArrivalDate(LocalDateTime.now().toString());

        return Arrays.asList(crazyAir, toughJet);
    }

    public static CompletableFuture<List<BusyFlight>> parsedScheduleCrazyAir() {
        BusyFlight crazyAir = new BusyFlight();
        crazyAir.setAirline("BritishAirways");
        crazyAir.setSupplier("CrazyAir");
        crazyAir.setFare(350);
        crazyAir.setDepartureAirportCode("LHR");
        crazyAir.setDestinationAirportCode("COK");
        crazyAir.setDepartureDate(LocalDateTime.now().toString());
        crazyAir.setArrivalDate(LocalDateTime.now().toString());

        return CompletableFuture.completedFuture(Arrays.asList(crazyAir));
    }

    public static CompletableFuture<List<BusyFlight>> parsedScheduleToughJet() {
        BusyFlight toughJet = new BusyFlight();
        toughJet.setAirline("Lufthansa");
        toughJet.setSupplier("ToughJet");
        toughJet.setFare(350);
        toughJet.setDepartureAirportCode("LHR");
        toughJet.setDestinationAirportCode("COK");
        toughJet.setDepartureDate(LocalDateTime.now().toString());
        toughJet.setArrivalDate(LocalDateTime.now().toString());
        return CompletableFuture.completedFuture(Arrays.asList(toughJet));
    }

    public static List<CrazyAir> crazyAirList() {
        CrazyAir crazyAir = new CrazyAir();
        crazyAir.setAirline("Lufthansa");
        crazyAir.setPrice("1500");
        crazyAir.setCabinClass("E");
        crazyAir.setDepartureAirportCode("10");
        crazyAir.setDepartureAirportCode("LHR");
        crazyAir.setDestinationAirportCode("COK");
        crazyAir.setArrivalDate(LocalDateTime.now().toString());
        crazyAir.setDepartureDate(LocalDateTime.now().toString());
        return Arrays.asList(crazyAir);
    }

    public static CrazyAir[] crazyAirArray() {
        CrazyAir crazyAir = new CrazyAir();
        crazyAir.setAirline("Lufthansa");
        crazyAir.setPrice("1500");
        crazyAir.setCabinClass("E");
        crazyAir.setDepartureAirportCode("10");
        crazyAir.setDepartureAirportCode("LHR");
        crazyAir.setDestinationAirportCode("COK");
        crazyAir.setArrivalDate(LocalDateTime.now().toString());
        crazyAir.setDepartureDate(LocalDateTime.now().toString());
        return new CrazyAir[]{crazyAir};
    }

    public static List<ToughJet> toughJetList() {
        ToughJet toughJet = new ToughJet();
        toughJet.setCarrier("Lufthansa");
        toughJet.setBasePrice("1500");
        toughJet.setTax("10");
        toughJet.setDiscount("10");
        toughJet.setDepartureAirportName("LHR");
        toughJet.setArrivalAirportName("COK");
        toughJet.setInboundDateTime(LocalDateTime.now().toString());
        toughJet.setOutboundDateTime(LocalDateTime.now().toString());
        return Arrays.asList(toughJet);
    }
}
