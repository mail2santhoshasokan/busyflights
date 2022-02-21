package com.example.busyflights.service.impl;

import com.example.busyflights.domain.BusyFlight;
import com.example.busyflights.domain.ToughJet;
import com.example.busyflights.parser.BusyFlightParser;
import com.example.busyflights.service.ToughJetService;
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
public class ToughJetServiceImpl implements ToughJetService {

    private static final Logger logger = LoggerFactory.getLogger(ToughJetServiceImpl.class);


    RestTemplate restTemplate;

    @Value("${toughJet.url.getFlights}")
    private String toughJetUrl;

    @Value("${toughJet.api.username}")
    private String username;

    @Value("${toughJet.api.password}")
    private String password;

    @Autowired
    private BusyFlightParser busyFlightParser;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<BusyFlight>> getFlightsFromToughJet(String from, String to, String outboundDate, String inboundDate, int numberOfAdults) {
        ResponseEntity<ToughJet[]> response = null;
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(headers);

        String formedUrl = toughJetUrl + "?from=" + from + "&to=" + to + "&outboundDate=" + outboundDate + "&numberOfAdults=" + numberOfAdults + "&inboundDate=" + inboundDate;
        try {
            response = restTemplate.exchange(formedUrl, HttpMethod.GET, request, ToughJet[].class);
        } catch (HttpStatusCodeException e) {
            logger.error("ToughJet API threw error please check ");
            e.printStackTrace();
        }
        if (response.getStatusCode().is2xxSuccessful() && response.getBody().length > 0) {
            return CompletableFuture.completedFuture(busyFlightParser.parseToughJetFlights(Arrays.asList(response.getBody())));
        }
        return CompletableFuture.completedFuture(Collections.EMPTY_LIST);
    }
}
