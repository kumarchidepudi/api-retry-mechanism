package com.kumar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class CallingService {
    private static final Logger log = LoggerFactory.getLogger(CallingService.class);
    private final RestTemplate restTemplate;

    public CallingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<Boolean, String> callService() {
        Map<Boolean, String> map = new HashMap<>();
        try {
            ResponseEntity<String> response =
                    restTemplate.getForEntity("http://localhost:8080/welcome/hello", String.class);
            map.put(true, response.getBody());
        } catch (Exception exception) {
            log.error("Something went wrong");
            map.put(false, null);
        }
        return map;
    }
}
