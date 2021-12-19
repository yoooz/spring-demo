package com.example.demo

import org.springframework.data.repository.CrudRepository

interface UserEntityRepository : CrudRepository<UserEntity, Int> {
}