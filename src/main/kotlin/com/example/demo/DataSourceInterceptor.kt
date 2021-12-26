package com.example.demo

import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DataSourceInterceptor: HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val dbName = request.getParameter("dbName")
        DataSourceContextHolder.setDataSourceType(dbName)

        return super.preHandle(request, response, handler)
    }
}