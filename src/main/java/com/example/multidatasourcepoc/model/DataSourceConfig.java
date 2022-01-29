package com.example.multidatasourcepoc.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "datasource_config")
public class DataSourceConfig {
    @Id
    @Column(name = "datasource_id")
    private Long datasourceId;

    @Column(name = "url")
    private String url;

    @Column(name = "datasource_name")
    private String datasourceName;

    @Column(name = "datasource_password")
    private String datasourcePassword;

    @Column(name = "tenant_id")
    private Long tenantId;
}
