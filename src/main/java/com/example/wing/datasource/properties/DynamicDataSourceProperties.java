package com.example.wing.datasource.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@ConfigurationProperties
public class DynamicDataSourceProperties {
    private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();
    public Map<String, DataSourceProperties> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourceProperties> datasource) {
        this.datasource = datasource;
    }
}
