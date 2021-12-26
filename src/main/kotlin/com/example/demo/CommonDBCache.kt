package com.example.demo

import org.slf4j.LoggerFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object CommonDBCache {
    private val LOGGER = LoggerFactory.getLogger(CommonDBCache::class.java.simpleName)
    const val commonDBName = "db_common"
    private var _targetDBSet = hashSetOf(commonDBName)
    val targetDBSet: Set<String>
        get() = _targetDBSet

    fun init() {
        LOGGER.info("[call]")

        var conn: Connection? = null
        var statement: Statement? = null
        var result: ResultSet? = null

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/db_common",
                "db_common",
                "db_common"
            )
            statement = conn.createStatement()
            result = statement.executeQuery("select * from connect_t")
            while (result.next()) {
                val dbName = result.getString(1)
                LOGGER.info("find db: $dbName")
                _targetDBSet.add(dbName)
            }
        } finally {
            result?.close()
            statement?.close()
            conn?.close()
        }
    }
}