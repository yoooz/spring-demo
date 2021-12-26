package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

class DynamicRoutingDataSourceResolver: AbstractRoutingDataSource() {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(DynamicRoutingDataSourceResolver::class.java.simpleName)
    }

    override fun determineCurrentLookupKey(): Any? {
        LOGGER.info("[call]")
        return DataSourceContextHolder.getDataSourceType()
    }
}