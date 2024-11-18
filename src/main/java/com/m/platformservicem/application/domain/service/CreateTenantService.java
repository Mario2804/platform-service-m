package com.m.platformservicem.application.domain.service;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.in.CreateTenantCommand;
import com.m.platformservicem.application.port.in.CreateTenantUseCase;
import com.m.platformservicem.application.port.out.SaveTenantPort;
import com.m.platformservicem.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateTenantService implements CreateTenantUseCase {

    private final SaveTenantPort saveTenantPort;


    @Override
    public Tenant createTenant(CreateTenantCommand createTenantCommand) {
        return saveTenantPort.save(Tenant.withoutId(createTenantCommand.name()));
    }
}
