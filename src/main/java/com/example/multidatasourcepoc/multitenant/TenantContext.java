package com.example.multidatasourcepoc.multitenant;

public class TenantContext {

    public static final String DEFAULT_TENANT_ID = "0";
    private TenantContext() {
    }

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.remove();
    }
}
