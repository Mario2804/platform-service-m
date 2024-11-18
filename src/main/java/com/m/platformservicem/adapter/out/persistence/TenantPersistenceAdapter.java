package com.m.platformservicem.adapter.out.persistence;

import com.m.platformservicem.application.domain.model.Tenant;
import com.m.platformservicem.application.port.out.LoadTenantPort;
import com.m.platformservicem.application.port.out.SaveTenantPort;
import com.m.platformservicem.common.PersistenceAdapter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
@Transactional
class TenantPersistenceAdapter implements SaveTenantPort, LoadTenantPort {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;


    @Override
    public Tenant save(Tenant tenant) {
        TenantJpaEntity tenantJpaEntity = tenantRepository.save(tenantMapper.mapToJpaEntity(tenant));
        return tenantMapper.mapToDomain(tenantJpaEntity);
    }

    @Override
    public Tenant load(Tenant.TenantId tenantId) {
        Optional<TenantJpaEntity> tenantJpaEntity = tenantRepository.findById(tenantId.getValue());
        return tenantJpaEntity.map(tenantMapper::mapToDomain).orElse(null);
    }

    @Override
    public List<Tenant> loadAll() {
        List<TenantJpaEntity> tenantJpaEntities = tenantRepository.findAll();
        return tenantJpaEntities.stream().map(tenantMapper::mapToDomain).toList();
    }
}
