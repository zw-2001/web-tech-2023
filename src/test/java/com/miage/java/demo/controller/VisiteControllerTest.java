package com.miage.java.demo.controller;

import com.miage.java.demo.service.VisiteService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VisiteControllerTest {
    // write your tests here
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private VisiteService visiteService;
    @InjectMocks
    private VisiteController visiteController;

    @Before
    public void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        visiteService = Mockito.mock(VisiteService.class);
        visiteController = new VisiteController(restTemplate, visiteService);
    }
    @org.junit.Test
    public void should_get_daily_stock() {
        // given
        String apiKey = "KXG4L563UAPZLZ2X";
        String symbol = "IBM";
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Mocked response");
        String apiUrl = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol + "&apikey=" + apiKey;
        ResponseEntity<String> response = ResponseEntity.ok("Mocked response");;
        Mockito.when(restTemplate.getForEntity(apiUrl, String.class)).thenReturn(mockResponse);
        // when
        String res = visiteController.getOverview("IBM").toString();

        // then
        Assertions.assertThat(res).isEqualTo(response.toString());
    }
    @org.junit.Test
    public void testListSp500Company() {
        // given
        String url = "https://raw.github.com/datasets/s-and-p-500-companies/main/data/constituents.csv";
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Mocked response");

        Mockito.when(restTemplate.getForEntity(url, String.class)).thenReturn(mockResponse);

        // when
        ResponseEntity<String> result = visiteController.listSp500Company();

        // then
        Assertions.assertThat(result.toString()).isEqualTo(mockResponse.toString());

    }
    @org.junit.Test
    public void testFindStockBySymbol() {
        // given
        String symbol = "AAPL";
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=KXG4L563UAPZLZ2X";
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Mocked response");

        Mockito.when(restTemplate.getForEntity(apiUrl, String.class)).thenReturn(mockResponse);

        // when
        ResponseEntity<String> result = visiteController.findStockBySymbol(symbol);

        // then
        Assertions.assertThat(result).isEqualTo(mockResponse);
    }
    @org.junit.Test
    public void testGetMostFrequentlyViewByDate() {
        // given
        String timestamp = "2022-01-01";
        List expected = List.of(new Object[] {"result"});
        Mockito.when(visiteService.getMostFrequentlyViewByDate(timestamp)).thenReturn(expected);

        // when
        List<Object[]> result = visiteController.getMostFrequentlyViewByDate(timestamp);

        // then
        Assertions.assertThat(result).hasSize(1);
    }
}
