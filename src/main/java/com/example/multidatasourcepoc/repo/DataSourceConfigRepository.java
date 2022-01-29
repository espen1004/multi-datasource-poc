package com.example.multidatasourcepoc.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.multidatasourcepoc.model.DataSourceConfig;

public interface DataSourceConfigRepository extends CrudRepository<DataSourceConfig, Long> {
    DataSourceConfig findDataSourceConfigByTenantId(Long tenantId);
}
