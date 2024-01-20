package com.miage.java.demo.service;
import com.miage.java.demo.entity.VisiteEntity;
import com.miage.java.demo.repository.VisiteEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class VisiteServiceTest {

    @Mock
    private VisiteEntityRepository visiteEntityRepository;

    @InjectMocks
    private VisiteService visiteService;

    @BeforeEach
    public void setUp() {
        visiteEntityRepository = Mockito.mock(VisiteEntityRepository.class);
    }

    @Test
    public void testSaveVisite() {
        // given
        VisiteEntity visiteEntityToSave = new VisiteEntity(UUID.randomUUID(),"symbol", LocalDateTime.now());

        // when
        Mockito.when(visiteEntityRepository.save(visiteEntityToSave)).thenReturn(visiteEntityToSave);
        VisiteEntity savedVisiteEntity = visiteService.saveVisite(visiteEntityToSave);

        // then
        assertEquals(savedVisiteEntity, visiteEntityToSave);
    }

    @Test
    public void testGetMostFrequentlyViewByDate() {
        // given
        String timestamp = "2022-01-01";
        Object[] result1 = {"data1"};
        Object[] result2 = {"data2"};
        List<Object> expectedResult = Arrays.asList(result1, result2);

        // when
        Mockito.when(visiteEntityRepository.findByTimestamp(timestamp)).thenReturn(expectedResult);
        List<Object> result = visiteService.getMostFrequentlyViewByDate(timestamp);

        // then
        assertEquals(result, expectedResult);
    }
}