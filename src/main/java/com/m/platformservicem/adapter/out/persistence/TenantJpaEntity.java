package com.m.platformservicem.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tenant")
@Data
@AllArgsConstructor
@NoArgsConstructor
class TenantJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
