package com.miage.java.demo.domain;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record Visite (
        Integer ID,
        String Symbole,
        Timestamp Timestamp) {
}
