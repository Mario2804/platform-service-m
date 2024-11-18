package com.m.platformservicem.application.port.out;

import com.m.platformservicem.application.domain.model.Tenant;

import java.util.List;

public interface LoadTenantPort {

    Tenant load(Tenant.TenantId tenantId);

    List<Tenant> loadAll();
}
