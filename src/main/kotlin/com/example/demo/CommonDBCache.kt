package com.example.demo

object CommonDBCache {
    const val commonDBName = "db_common"
    val targetDBSet = hashSetOf(commonDBName)

    fun add(dbName: String) {
        targetDBSet.add(dbName)
    }
}