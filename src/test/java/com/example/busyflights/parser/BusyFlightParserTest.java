package com.example.busyflights.parser;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.factory.TestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusyFlightParserTest {

    @InjectMocks
    BusyFlightParser busyFlightParser;

    @Test
    void testToCheckIfCrazyAirDataIsParsed(){
        List<BusyFlight> busyFlightList = busyFlightParser.parseCrazyAirFlights(TestFactory.crazyAirList());
        Assertions.assertEquals(1, busyFlightList.size());
        Assertions.assertEquals("Lufthansa", busyFlightList.get(0).getAirline());
    }

    @Test
    void testToCheckIfToughJetDataIsParsed(){
        List<BusyFlight> busyFlightList = busyFlightParser.parseToughJetFlights(TestFactory.toughJetList());
        Assertions.assertEquals(1, busyFlightList.size());
        Assertions.assertEquals("Lufthansa", busyFlightList.get(0).getAirline());
    }

}
