package com.miage.java.demo.repository;

import com.miage.java.demo.entity.VisiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteEntityRepository extends JpaRepository<VisiteEntity, Integer> {

}
