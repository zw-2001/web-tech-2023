package com.miage.java.demo.controller;

import com.miage.java.demo.service.VisiteService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VisiteControllerTest {

    @Mock
    @Autowired
    private RestTemplate restTemplate;
    @Mock
    @Autowired
    private VisiteService visiteService;
    @InjectMocks
    private VisiteController visiteController;

    @BeforeEach
    public void setUp() {
        visiteController = new VisiteController();
    }

    @ParameterizedTest
    @ValueSource(strings = {"IBM", "AAPL", "GOOG"})
    public void findStockBySymbol_should_return_response_code_200(String symbol) {
        HttpStatusCode response = visiteController.getOverview(symbol).getStatusCode();
        assertNotNull(response);
        assertEquals(String.valueOf(response), "200 OK");
    }
    @Test
    public void listSp500Company_should_return_response_code_200() {
        HttpStatusCode response = visiteController.listSp500Company().getStatusCode();
        assertNotNull(response);
        assertEquals(String.valueOf(response), "200 OK");
    }
    @Test
    public void findStockBySymbol_check_data() {
        String symbol = "IBM";
        String apiKey = "5VBP2LU6D9J4P3NT";
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        assertEquals("{Symbol: \"IMB\"}", String.valueOf(response));
        assertEquals("{Output Size: \"Compact\"}", String.valueOf(response));
        assertEquals("{Time Zone: \"US/Eastern\"}", String.valueOf(response));
    }
    @Test
    public void testGetMostFrequentlyViewByDate() {
        // given
        String timestamp = "2022-01-01";
        List expected = List.of(new Object[] {"result"});
        Mockito.when(visiteService.getMostFrequentlyViewByDate(timestamp)).thenReturn(expected);

        // when
        List<Object> result = visiteController.getMostFrequentlyViewByDate(timestamp);

        // then
        //Assertions.assertThat(result).hasSize(1);
    }
}
