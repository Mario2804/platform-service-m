package com.m.platformservicem.application.port.out;

import com.m.platformservicem.application.domain.model.Tenant;

public interface SaveTenantPort {

    Tenant save(Tenant tenant);
}
