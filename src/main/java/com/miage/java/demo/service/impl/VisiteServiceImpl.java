package com.miage.java.demo.service.impl;

import com.miage.java.demo.service.VisiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class VisiteServiceImpl implements VisiteService {

    private final com.miage.java.demo.repository.VisiteEntityRepository VisiteEntityRepository;

}
