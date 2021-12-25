package com.example.demo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class DataSourdeAdvice {

    @Around("@annotation(dataSource)")
    fun adviceMethod(proceedingJoinPoint: ProceedingJoinPoint, dataSource: DataSource) {
        DataSourceContextHolder.setDataSourceType(dataSource.value)
        proceedingJoinPoint.proceed()
    }
}