package com.m.platformservicem.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
class GetTenantResponse {

    private UUID Id;
    private String name;
}
