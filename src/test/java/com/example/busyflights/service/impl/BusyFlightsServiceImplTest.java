package com.example.busyflights.service.impl;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.factory.TestFactory;
import com.example.busyflights.service.CrazyAirService;
import com.example.busyflights.service.ToughJetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusyFlightsServiceImplTest {

    @InjectMocks
    BusyFlightsServiceImpl busyFlightsService;

    @Mock
    CrazyAirService crazyAirService;

    @Mock
    ToughJetService toughJetService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIfBusyFlightsReceivesDataFromApis() {
        when(crazyAirService.getFlightFromCrazyAir(any(), any(), any(), any(), anyInt())).thenReturn(TestFactory.parsedScheduleCrazyAir());
        when(toughJetService.getFlightsFromToughJet(any(), any(), any(), any(), anyInt())).thenReturn(TestFactory.parsedScheduleToughJet());
        List<BusyFlight> busyFlightList = busyFlightsService.searchFlights("LHR", "COK", "", "", 2);
        Assertions.assertEquals(2, busyFlightList.size());
        Assertions.assertEquals("CrazyAir", busyFlightList.get(0).getSupplier());
        Assertions.assertEquals("ToughJet", busyFlightList.get(1).getSupplier());
    }


}
