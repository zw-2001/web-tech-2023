package com.miage.java.demo.service;

import com.miage.java.demo.entity.VisiteEntity;
import com.miage.java.demo.repository.VisiteEntityRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class VisiteService {

    @Autowired
    private final VisiteEntityRepository visiteEntityRepository;

    public VisiteEntity saveVisite(VisiteEntity visiteEntity) {
        return visiteEntityRepository.save(visiteEntity);
    }

    public List<Object> getMostFrequentlyViewByDate(String timestamp) {
        return visiteEntityRepository.findByTimestamp(timestamp);
    }
}
