package com.m.platformservicem.adapter.in.web;

import com.m.platformservicem.application.port.in.CreateTenantCommand;
import com.m.platformservicem.application.port.in.CreateTenantUseCase;
import com.m.platformservicem.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class TenantController {

    private final CreateTenantUseCase createTenantUseCase;
    private final CreateTenantMapper createTenantMapper;


    @PostMapping
    public CreateTenantResponse createTenant(CreateTenantRequest createTenantRequest) {
        CreateTenantCommand createTenantCommand = new CreateTenantCommand(createTenantRequest.getTenantName());

        return createTenantMapper.mapToResponse(createTenantUseCase.createTenant(createTenantCommand));
    }

}
