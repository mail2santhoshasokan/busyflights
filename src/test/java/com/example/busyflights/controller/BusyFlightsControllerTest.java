package com.example.busyflights.controller;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.factory.TestFactory;
import com.example.busyflights.service.BusyFlightsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusyFlightsControllerTest {

    @InjectMocks
    BusyFlightsController busyFlightsController;

    @Mock
    BusyFlightsService busyFlightsService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToCheckIfSchedulesAreReturned() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(busyFlightsService.searchFlights(any(), any(), any(), any(), anyInt())).thenReturn(TestFactory.combinedFlightList());

        ResponseEntity<List<BusyFlight>> responseEntity = busyFlightsController.searchFlights("LHR", "COK", "", "", 3);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertNotNull(responseEntity.getBody());
    }
}
