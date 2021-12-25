package com.example.demo

import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DataSourceInterceptor: HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val dsType = DataSource.DataSourceType.from(request.getParameter("ds"))
        DataSourceContextHolder.setDataSourceType(dsType)

        return super.preHandle(request, response, handler)
    }
}