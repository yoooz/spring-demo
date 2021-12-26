package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	getConnectInfo()
	runApplication<DemoApplication>(*args)
}

fun getConnectInfo() {
	val logger = LoggerFactory.getLogger("getConnectInfo")
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
			logger.info(dbName)
			CommonDBCache.add(dbName)
		}
	} finally {
		result?.close()
		statement?.close()
		conn?.close()
	}
}
