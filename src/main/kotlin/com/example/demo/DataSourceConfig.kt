package com.example.demo

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.handler.MappedInterceptor

@Component
@Configuration
class DataSourceConfig {

    @Bean
    fun dataSourceInterceptor(): HandlerInterceptor {
        return DataSourceInterceptor()
    }

    @Bean
    fun interceptorMapping(): MappedInterceptor {
        return MappedInterceptor(arrayOf("/**"), dataSourceInterceptor())
    }

    @Bean
    fun firstDataSource(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://127.0.0.1:3307/db_1"
        config.username = "db_1"
        config.password = "db_1"

        return HikariDataSource(config)
    }

    @Bean
    fun secondDataSource(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://127.0.0.1:3307/db_2"
        config.username = "db_2"
        config.password = "db_2"

        return HikariDataSource(config)
    }

    @Bean
    @Primary
    fun dataSourceResolver(): DynamicRoutingDataSourceResolver {
        val resolver = DynamicRoutingDataSourceResolver()

        val dataSources: Map<Any, Any> = mapOf(
            Pair("db_1", firstDataSource()),
            Pair("db_2", secondDataSource())
        )

        resolver.setTargetDataSources(dataSources)

        resolver.setDefaultTargetDataSource(firstDataSource())

        return resolver
    }
}