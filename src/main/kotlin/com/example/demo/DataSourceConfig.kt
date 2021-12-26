package com.example.demo

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.handler.MappedInterceptor

@Component
@Configuration
class DataSourceConfig {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(DataSourceConfig::class.java.simpleName)
    }

    @Bean
    fun dataSourceInterceptor(): HandlerInterceptor {
        LOGGER.info("[call] dataSourceInterceptor")
        return DataSourceInterceptor()
    }

    @Bean
    fun interceptorMapping(): MappedInterceptor {
        LOGGER.info("[call] interceptorMapping")
        return MappedInterceptor(arrayOf("/**"), dataSourceInterceptor())
    }

    private fun createDataSource(dbName: String): HikariDataSource {
        LOGGER.info("[call] createDataSource: $dbName")

        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://127.0.0.1:3307/$dbName"
        config.username = dbName
        config.password = dbName

        return HikariDataSource(config)
    }

    @Bean
    @Primary
    fun dataSourceResolver(): DynamicRoutingDataSourceResolver {
        LOGGER.info("[call] dataSourceResolver")
        val resolver = DynamicRoutingDataSourceResolver()

        val dataSources: MutableMap<Any, Any> = mutableMapOf()
        CommonDBCache.targetDBSet.forEach {
            dataSources[it] = createDataSource(it)
        }

        resolver.setTargetDataSources(dataSources)

        resolver.setDefaultTargetDataSource(dataSources[CommonDBCache.commonDBName]!!)

        return resolver
    }
}