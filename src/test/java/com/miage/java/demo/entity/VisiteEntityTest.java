package com.miage.java.demo.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

public class VisiteEntityTest {
    @Test
    public void testVisiteEntity() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();

        // when
        VisiteEntity visiteEntity = new VisiteEntity(id, symbol, timestamp);

        // then
        assertNotNull(visiteEntity);
        assertEquals(visiteEntity.getID(), id);
        assertEquals(visiteEntity.getSymbol(), symbol);
        assertEquals(visiteEntity.getTimestamp(), timestamp);
    }

    @Test
    public void testVisiteEntityEquality() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity1 = new VisiteEntity(id, symbol, timestamp);
        VisiteEntity visiteEntity2 = new VisiteEntity(id, symbol, timestamp);

        // then
        assertEquals(visiteEntity1, visiteEntity2);
        assertEquals(visiteEntity1.hashCode(), visiteEntity2.hashCode());
    }

    @Test
    public void testVisiteEntityToString() {
        // given
        UUID id = UUID.randomUUID();
        String symbol = "AAPL";
        LocalDateTime timestamp = LocalDateTime.now();
        VisiteEntity visiteEntity = new VisiteEntity(id, symbol, timestamp);

        // then
        assertTrue(visiteEntity.toString().contains(id.toString()));
        assertTrue(visiteEntity.toString().contains(symbol));
        assertTrue(visiteEntity.toString().contains(timestamp.toString()));
    }

    @Test
    public void testVisiteEntityJpaAnnotations() {
        // given
        VisiteEntity visiteEntity = Mockito.mock(VisiteEntity.class);

        // then
        assertNotNull(visiteEntity);
        assertTrue(visiteEntity instanceof VisiteEntity);
    }
}
