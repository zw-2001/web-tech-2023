package com.miage.java.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "visite")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisiteEntity {
    @Id
    private Integer ID;
    @Column(name = "Symbole")
    private String Symbole;
    @Column(name="Timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private String Timestamp;
}
