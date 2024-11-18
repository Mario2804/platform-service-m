package com.m.platformservicem.application.port.in;

import com.m.platformservicem.application.domain.model.Tenant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTenantCommand(@NotNull Tenant.TenantId id, @NotBlank String name) {
}
