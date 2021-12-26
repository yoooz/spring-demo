package com.example.demo

object DataSourceContextHolder {

    private val contextHolder = ThreadLocal<String>()

    fun setDataSourceType(dbName: String) {
        contextHolder.set(dbName)
    }

    fun getDataSourceType(): String {
        return contextHolder.get() ?: ""
    }

    fun clear() {
        contextHolder.remove()
    }

}