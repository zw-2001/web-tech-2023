package com.miage.java.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class VisiteTest {
    @Test
    public void testVisiteRecord() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();

        // when
        Visite visite = new Visite(id, symbol, timestamp);

        // then
        assertNotNull(visite);
        assertEquals(visite.ID(),id);
        assertEquals(visite.symbol(), symbol);
        assertEquals(visite.timestamp(), timestamp);
    }

    @Test
    public void testVisiteRecordEquality() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        Visite visite1 = new Visite(id, symbol, timestamp);
        Visite visite2 = new Visite(id, symbol, timestamp);

        // then
        assertEquals(visite1, visite2);
        assertEquals(visite1.hashCode(), visite2.hashCode());
    }

    @Test
    public void testVisiteRecordToString() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        Visite visite = new Visite(id, symbol, timestamp);

        // then
        assertTrue(visite.toString().contains(id.toString()));
        assertTrue(visite.toString().contains(symbol));
        assertTrue(visite.toString().contains(timestamp.toString()));
    }
}
