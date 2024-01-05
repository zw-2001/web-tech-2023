package com.miage.java.demo.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
public record Visite (
        UUID ID,
        String symbol,
        LocalDateTime timestamp) {
}
