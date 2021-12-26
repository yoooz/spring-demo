package com.example.demo

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

class DynamicRoutingDataSourceResolver: AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any? {
        return DataSourceContextHolder.getDataSourceType()
    }
}