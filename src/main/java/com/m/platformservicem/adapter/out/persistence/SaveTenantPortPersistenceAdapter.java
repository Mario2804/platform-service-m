package com.m.platformservicem.adapter.out.persistence;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.out.SaveTenantPort;
import com.m.platformservicem.common.PersistenceAdapter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
@Transactional
class SaveTenantPortPersistenceAdapter implements SaveTenantPort {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;


    @Override
    public Tenant save(Tenant tenant) {
        TenantJpaEntity tenantJpaEntity = tenantRepository.save(tenantMapper.mapToJpaEntity(tenant));
        return tenantMapper.mapToDomain(tenantJpaEntity);
    }
}
