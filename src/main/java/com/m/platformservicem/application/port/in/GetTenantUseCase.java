package com.m.platformservicem.application.port.in;

import com.m.platformservicem.application.domain.model.Tenant;

import java.util.List;

public interface GetTenantUseCase {

    Tenant getTenant(Tenant.TenantId tenantId);

    List<Tenant> getAllTenants();
}
