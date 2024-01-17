package com.miage.java.demo.domain;

import org.assertj.core.api.Assertions;

import java.time.LocalDateTime;
import java.util.UUID;

public class VisiteTest {
    @org.junit.Test
    public void testVisiteRecord() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();

        // when
        Visite visite = new Visite(id, symbol, timestamp);

        // then
        Assertions.assertThat(visite).isNotNull();
        Assertions.assertThat(visite.ID()).isEqualTo(id);
        Assertions.assertThat(visite.symbol()).isEqualTo(symbol);
        Assertions.assertThat(visite.timestamp()).isEqualTo(timestamp);
    }

    @org.junit.Test
    public void testVisiteRecordEquality() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        Visite visite1 = new Visite(id, symbol, timestamp);
        Visite visite2 = new Visite(id, symbol, timestamp);

        // then
        Assertions.assertThat(visite1).isEqualTo(visite2);
        Assertions.assertThat(visite1.hashCode()).isEqualTo(visite2.hashCode());
    }

    @org.junit.Test
    public void testVisiteRecordToString() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        Visite visite = new Visite(id, symbol, timestamp);

        // then
        Assertions.assertThat(visite.toString()).contains(id.toString(), symbol, timestamp.toString());
    }
}
