package com.m.platformservicem.application.domain.service;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.in.GetTenantUseCase;
import com.m.platformservicem.application.port.out.LoadTenantPort;
import com.m.platformservicem.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetTenantService implements GetTenantUseCase {

    private final LoadTenantPort loadTenantPort;


    @Override
    public Tenant getTenant(Tenant.TenantId tenantId) {
        return loadTenantPort.load(tenantId);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return loadTenantPort.loadAll();
    }
}
