package com.m.platformservicem.adapter.in.web;

import com.m.platformservicem.application.domain.model.Tenant;
import org.springframework.stereotype.Component;

@Component
class GetTenantMapper {

    GetTenantResponse mapToResponse(Tenant tenant) {
        return new GetTenantResponse(tenant.getId().getValue(), tenant.getName());
    }
}
