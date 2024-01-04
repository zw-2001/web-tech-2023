package com.miage.java.demo.controller;

import com.miage.java.demo.service.VisiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visite")
@AllArgsConstructor
public class VisiteController {

    private String apiKey = "KXG4L563UAPZLZ2X";
    private final VisiteService VisiteService;

    @GetMapping("/{symbol}")
    public String findStockBySymbol(@PathVariable String symbol) {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
    }

    @GetMapping("/list-sp500-company")
    public String listSp500Company() {
        return "https://raw.github.com/datasets/s-and-p-500-companies/main/data/constituents.csv";
    }
}
