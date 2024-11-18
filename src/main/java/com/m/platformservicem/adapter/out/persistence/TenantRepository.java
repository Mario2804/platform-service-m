package com.m.platformservicem.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface TenantRepository extends JpaRepository<TenantJpaEntity, UUID> {
}
