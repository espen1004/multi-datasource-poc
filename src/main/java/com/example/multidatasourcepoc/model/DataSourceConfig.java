package com.example.multidatasourcepoc.model;

import lombok.Data;

@Data
public class DataSourceConfig {
    private Long datasourceId;

    private String url;

    private String datasourceName;

    private String datasourcePassword;

    private String tenantId;
}
