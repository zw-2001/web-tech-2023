package com.miage.java.demo.controller;

import com.miage.java.demo.entity.VisiteEntity;
import com.miage.java.demo.service.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/visite")
@CrossOrigin(origins = "http://localhost:4200")
public class VisiteController {

    public static RestTemplate restTemplate = new RestTemplate();
    private String apiKey = "5VBP2LU6D9J4P3NT";
    @Autowired
    private VisiteService visiteService;

    @GetMapping("/daily-price/{symbol}")
    public ResponseEntity<String> findStockBySymbol(@PathVariable String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity = VisiteEntity.builder()
                .symbol(symbol)
                .timestamp(timestamp)
                .build();
        visiteService.saveVisite(visiteEntity);
        return response;
    }

    @GetMapping("/list-sp500-company")
    public ResponseEntity<String> listSp500Company() {
        String url = "https://raw.github.com/datasets/s-and-p-500-companies/main/data/constituents.csv";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
    @GetMapping("/overview/{symbol}")
    public ResponseEntity<String> getOverview(@PathVariable String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol + "&apikey=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return response;
    }

    @GetMapping("/most-frequently-view/{timestamp}")
    public List<Object[]> getMostFrequentlyViewByDate(@PathVariable String timestamp) {
        return visiteService.getMostFrequentlyViewByDate(timestamp);
    }
}
