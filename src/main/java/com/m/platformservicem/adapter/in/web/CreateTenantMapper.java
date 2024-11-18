package com.m.platformservicem.adapter.in.web;

import com.m.platformservicem.application.domain.model.Tenant;
import org.springframework.stereotype.Component;

@Component
class CreateTenantMapper {

    CreateTenantResponse mapToResponse(Tenant tenant) {
        return new CreateTenantResponse(tenant.getId().getValue(), tenant.getName());
    }
}
