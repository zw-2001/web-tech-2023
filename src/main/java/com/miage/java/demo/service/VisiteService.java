package com.miage.java.demo.service;

import com.miage.java.demo.entity.VisiteEntity;
import com.miage.java.demo.repository.VisiteEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class VisiteService {

    private final VisiteEntityRepository visiteEntityRepository;

    public VisiteEntity saveVisite(VisiteEntity visiteEntity) {
        return visiteEntityRepository.save(visiteEntity);
    }
}
