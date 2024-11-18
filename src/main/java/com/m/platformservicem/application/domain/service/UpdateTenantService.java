package com.m.platformservicem.application.domain.service;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.in.UpdateTenantCommand;
import com.m.platformservicem.application.port.in.UpdateTenantUseCase;
import com.m.platformservicem.application.port.out.LoadTenantPort;
import com.m.platformservicem.application.port.out.SaveTenantPort;
import com.m.platformservicem.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateTenantService implements UpdateTenantUseCase {

    private final SaveTenantPort saveTenantPort;
    private final LoadTenantPort loadTenantPort;


    @Override
    public Tenant updateTenant(UpdateTenantCommand updateTenantCommand) {
        Tenant tenant = loadTenantPort.load(updateTenantCommand.id());
        if (tenant != null) {
            return saveTenantPort.save(Tenant.withId(updateTenantCommand.id(), updateTenantCommand.name()));
        } else {
            return null;
        }
    }
}
