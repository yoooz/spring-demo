package com.example.demo

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

class DynamicRoutingDataSourceResolver: AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any? {
        return if (DataSourceContextHolder.getDataSourceType() == DataSource.DataSourceType.STG) {
            "db_example_1"
        } else {
            "db_example_2"
        }
    }
}