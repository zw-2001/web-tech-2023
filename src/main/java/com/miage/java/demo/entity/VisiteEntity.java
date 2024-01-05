package com.miage.java.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(name = "id")
    private UUID id;
    @Column(name = "Symbole")
    private String Symbole;
    @Column(name="Timestamp")
    private LocalDateTime timestamp;
}
