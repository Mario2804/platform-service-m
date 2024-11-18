package com.m.platformservicem.adapter.in.web;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.in.CreateTenantCommand;
import com.m.platformservicem.application.port.in.CreateTenantUseCase;
import com.m.platformservicem.application.port.in.GetTenantUseCase;
import com.m.platformservicem.application.port.in.UpdateTenantCommand;
import com.m.platformservicem.application.port.in.UpdateTenantUseCase;
import com.m.platformservicem.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@WebAdapter
@RestController
@RequiredArgsConstructor
class TenantController {

    private final CreateTenantUseCase createTenantUseCase;
    private final UpdateTenantUseCase updateTenantUseCase;
    private final GetTenantUseCase getTenantUseCase;

    private final CreateTenantMapper createTenantMapper;
    private final UpdateTenantMapper updateTenantMapper;
    private final GetTenantMapper getTenantMapper;


    @PostMapping
    public CreateTenantResponse createTenant(CreateTenantRequest createTenantRequest) {
        CreateTenantCommand createTenantCommand = new CreateTenantCommand(createTenantRequest.getTenantName());

        return createTenantMapper.mapToResponse(createTenantUseCase.createTenant(createTenantCommand));
    }

    @PutMapping
    public UpdateTenantResponse updateTenant(@PathVariable UUID id, UpdateTenantRequest updateTenantRequest) {
        UpdateTenantCommand updateTenantCommand = new UpdateTenantCommand(new Tenant.TenantId(id), updateTenantRequest.getTenantName());

        return updateTenantMapper.mapToResponse(updateTenantUseCase.updateTenant(updateTenantCommand));
    }

    @GetMapping
    public Tenant getTenant(@PathVariable UUID id) {
        return getTenantUseCase.getTenant(new Tenant.TenantId(id));
    }

    @GetMapping
    public List<GetTenantResponse> getTenants() {
        return getTenantUseCase.getAllTenants().stream().map(getTenantMapper::mapToResponse).toList();
    }

}
