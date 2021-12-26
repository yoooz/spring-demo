package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DataSourceInterceptor: HandlerInterceptor {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(DataSourceInterceptor::class.java.simpleName)
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        LOGGER.info("[call]")
        val dbName = request.getParameter("dbName")
        DataSourceContextHolder.setDataSourceType(dbName)

        return super.preHandle(request, response, handler)
    }
}