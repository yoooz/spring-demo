package com.example.demo

import org.slf4j.LoggerFactory

object DataSourceContextHolder {
    private val LOGGER = LoggerFactory.getLogger(DataSourceContextHolder::class.java.simpleName)

    private val contextHolder = ThreadLocal<String>()

    fun setDataSourceType(dbName: String) {
        LOGGER.info("[call] setDataSourceType: $dbName")
        contextHolder.set(dbName)
    }

    fun getDataSourceType(): String {
        LOGGER.info("[call] getDataSourceType")
        return contextHolder.get() ?: ""
    }

    fun clear() {
        contextHolder.remove()
    }

}