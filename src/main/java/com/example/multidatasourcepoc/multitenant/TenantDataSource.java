package com.example.multidatasourcepoc.multitenant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import com.example.multidatasourcepoc.model.DataSourceConfig;
import com.example.multidatasourcepoc.repo.DataSourceConfigRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TenantDataSource {

    private final HashMap<Long, DataSource> dataSources = new HashMap<>();

    private final DataSourceConfigRepository dataSourceConfigRepository;

    public DataSource getDataSource(Long tenantId) {
        if (dataSources.get(tenantId) != null) {
            return dataSources.get(tenantId);
        }
        DataSource dataSource = createDataSource(tenantId);
        if (dataSource != null) {
            dataSources.put(tenantId, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<Long, DataSource> getAll() {
        List<DataSourceConfig> configList = StreamSupport.stream((dataSourceConfigRepository.findAll().spliterator()), false).toList();
        Map<Long, DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getTenantId());
            result.put(config.getTenantId(), dataSource);
        }
        return result;
    }

    private DataSource createDataSource(Long tenantId) {
        DataSourceConfig config = dataSourceConfigRepository.findDataSourceConfigByTenantId(tenantId);
        if (config != null) {
            DataSourceBuilder<?> factory = DataSourceBuilder
                    .create().driverClassName("org.postgresql.Driver")
                    .username(config.getDatasourceName())
                    .password(config.getDatasourcePassword())
                    .url(config.getUrl());
            return factory.build();
        }
        return null;
    }

}
