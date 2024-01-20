package com.miage.java.demo.repository;

import com.miage.java.demo.entity.VisiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisiteEntityRepository extends JpaRepository<VisiteEntity, Integer> {

    @Query("SELECT visite.symbol, COUNT(visite.symbol) FROM VisiteEntity visite " +
            "WHERE FUNCTION('TO_CHAR', visite.timestamp, 'YYYY-MM-DD HH24:MI:SS') LIKE CONCAT('%', :timestamp, '%') " +
            "GROUP BY visite.symbol ORDER BY COUNT(visite.symbol) DESC")
    public List<Object[]> findByTimestamp(@Param("timestamp") String timestamp);
}
