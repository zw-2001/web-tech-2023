package com.miage.java.demo.entity;

import org.assertj.core.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

public class VisiteEntityTest {
    @org.junit.Test
    public void testVisiteEntity() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();

        // when
        VisiteEntity visiteEntity = new VisiteEntity(id, symbol, timestamp);

        // then
        Assertions.assertThat(visiteEntity).isNotNull();
        Assertions.assertThat(visiteEntity.getID()).isEqualTo(id);
        Assertions.assertThat(visiteEntity.getSymbol()).isEqualTo(symbol);
        Assertions.assertThat(visiteEntity.getTimestamp()).isEqualTo(timestamp);
    }

    @org.junit.Test
    public void testVisiteEntityEquality() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity1 = new VisiteEntity(id, symbol, timestamp);
        VisiteEntity visiteEntity2 = new VisiteEntity(id, symbol, timestamp);

        // then
        Assertions.assertThat(visiteEntity1).isEqualTo(visiteEntity2);
        Assertions.assertThat(visiteEntity1.hashCode()).isEqualTo(visiteEntity2.hashCode());
    }

    @org.junit.Test
    public void testVisiteEntityToString() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity = new VisiteEntity(id, symbol, timestamp);

        // then
        Assertions.assertThat(visiteEntity.toString()).contains(id.toString(), symbol, timestamp.toString());
    }

    @org.junit.Test
    public void testVisiteEntityJpaAnnotations() {
        // given
        VisiteEntity visiteEntity = Mockito.mock(VisiteEntity.class);

        // then
        Assertions.assertThat(visiteEntity).isNotNull();
        Assertions.assertThat(visiteEntity).isInstanceOf(VisiteEntity.class);
    }
}
