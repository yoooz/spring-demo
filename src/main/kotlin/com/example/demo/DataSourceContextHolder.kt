package com.example.demo

object DataSourceContextHolder {

    private val contextHolder = ThreadLocal<DataSource.DataSourceType>()

    fun setDataSourceType(type: DataSource.DataSourceType) {
        contextHolder.set(type)
    }

    fun getDataSourceType(): DataSource.DataSourceType {
        return contextHolder.get() ?: DataSource.DataSourceType.STG
    }

    fun clear() {
        contextHolder.remove()
    }

}