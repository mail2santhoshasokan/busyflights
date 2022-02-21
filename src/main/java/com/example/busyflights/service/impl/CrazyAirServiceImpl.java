package com.example.busyflights.service.impl;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.domain.CrazyAir;
import com.example.busyflights.parser.BusyFlightParser;
import com.example.busyflights.service.CrazyAirService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class CrazyAirServiceImpl implements CrazyAirService {

    private static final Logger logger = LoggerFactory.getLogger(CrazyAirServiceImpl.class);

    RestTemplate restTemplate;

    @Value("${crazyAir.url.getFlights}")
    private String url;

    @Value("${crazyAir.api.username}")
    private String username;

    @Value("${crazyAir.api.password}")
    private String password;

    @Autowired
    private BusyFlightParser busyFlightParser;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<BusyFlight>> getFlightFromCrazyAir(String origin, String destination, String departureDate, String returnDate, int passengerCount) {
        ResponseEntity<CrazyAir[]> response = null;
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(headers);

        String formedUrl = url + "?departureDate=" + departureDate + "&destination=" + destination + "&origin=" + origin + "&passengerCount=" + passengerCount + "&returnDate=" + returnDate;

        try {
            response = restTemplate.exchange(formedUrl, HttpMethod.GET, request, CrazyAir[].class);
        } catch (HttpStatusCodeException e) {
            logger.error("please check the error thrown by api : ");
            e.printStackTrace();
        }
        if (response.getStatusCode().is2xxSuccessful() & response.getBody().length > 0) {
            return CompletableFuture.completedFuture(busyFlightParser.parseCrazyAirFlights(Arrays.asList(response.getBody())));
        }
        return CompletableFuture.completedFuture(Collections.EMPTY_LIST);
    }
}
