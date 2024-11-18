package com.m.platformservicem.application.port.in;

import jakarta.validation.constraints.NotBlank;

public record CreateTenantCommand(@NotBlank String name) {
}
