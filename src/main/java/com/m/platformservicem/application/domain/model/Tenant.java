package com.m.platformservicem.application.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Tenant {

    @Getter private final TenantId id;
    @Getter private final String name;

    @Value
    public static class TenantId {
        UUID value;
    }

    public static Tenant withId(TenantId id, String name) {
        return new Tenant(id, name);
    }

    public static Tenant withoutId(String name) {
        return new Tenant(null, name);
    }
}
