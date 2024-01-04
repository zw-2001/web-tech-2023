package com.miage.java.demo.controller;

import com.miage.java.demo.service.VisiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("visite")
@AllArgsConstructor
public class VisiteController {

    private String apiKey = "KXG4L563UAPZLZ2X";

    private final VisiteService VisiteService;

    @GetMapping("/{symbol}")
    public ResponseEntity<String> findStockBySymbol(@PathVariable String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        WebClient.Builder webClientBuilder = WebClient.builder();
        String jsonData = webClientBuilder.baseUrl(apiUrl).build().get().retrieve().bodyToMono(String.class).block();
        return ResponseEntity.ok(jsonData);
    }

    @GetMapping("/list-sp500-company")
    public ResponseEntity<String> listSp500Company() {
        String url = "https://raw.github.com/datasets/s-and-p-500-companies/main/data/constituents.csv";
        WebClient.Builder webClientBuilder = WebClient.builder();
        String jsonData = webClientBuilder.baseUrl(url).build().get().retrieve().bodyToMono(String.class).block();
        return ResponseEntity.ok(jsonData);
    }
}
