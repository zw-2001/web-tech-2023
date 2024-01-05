package com.miage.java.demo.controller;

import com.miage.java.demo.entity.VisiteEntity;
import com.miage.java.demo.service.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/visite")
public class VisiteController {

    public static RestTemplate restTemplate = new RestTemplate();
    private String apiKey = "KXG4L563UAPZLZ2X";
    @Autowired
    private VisiteService visiteService;

    @PostMapping("/get-stock-price/{symbol}")
    public VisiteEntity getStockPrice(@PathVariable String symbol) {
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity = VisiteEntity.builder()
                .symbol(symbol)
                .timestamp(timestamp)
                .build();
        return visiteService.saveVisite(visiteEntity);
    }

    @GetMapping("/daily-price/{symbol}")
    public ResponseEntity<String> findStockBySymbol(@PathVariable String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
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
    /*
     * TODO
     *  an endpoint that returns the most frequently view symbol in View table (the symbol that was called the most)
     *  in the date, week, month, year
     * */
}
