package com.m.platformservicem.adapter.in.web;

import com.m.platformservicem.application.domain.model.Tenant;
import org.springframework.stereotype.Component;

@Component
class UpdateTenantMapper {

    UpdateTenantResponse mapToResponse(Tenant tenant) {
        return new UpdateTenantResponse(tenant.getId().getValue(), tenant.getName());
    }
}
