package com.example.multidatasourcepoc.multitenant;

import java.util.Objects;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_TENANT ="0";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t =  TenantContext.getCurrentTenant();
        return Objects.requireNonNullElse(t, DEFAULT_TENANT);
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
