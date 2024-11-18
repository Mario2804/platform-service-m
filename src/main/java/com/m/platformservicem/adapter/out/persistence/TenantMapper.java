package com.m.platformservicem.adapter.out.persistence;

import com.m.platformservicem.application.domain.model.Tenant;
import org.springframework.stereotype.Component;

@Component
class TenantMapper {

    Tenant mapToDomain(TenantJpaEntity tenant) {
        return Tenant.withId(new Tenant.TenantId(tenant.getId()), tenant.getName());
    }

    TenantJpaEntity mapToJpaEntity(Tenant tenant) {
        return new TenantJpaEntity(tenant.getId() == null ? null : tenant.getId().getValue(), tenant.getName());
    }
}
