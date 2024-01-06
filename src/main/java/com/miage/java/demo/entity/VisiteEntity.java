package com.miage.java.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "visite_v2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID ID;
    @Column(name = "symbol")
    private String symbol;
    @Column(name="timestamp")
    private LocalDateTime timestamp;
}
