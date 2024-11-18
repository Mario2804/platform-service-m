package com.m.platformservicem.application.port.in;

import com.m.platformservicem.application.domain.model.Tenant;

public interface UpdateTenantUseCase {

    Tenant updateTenant(UpdateTenantCommand updateTenantCommand);
}
