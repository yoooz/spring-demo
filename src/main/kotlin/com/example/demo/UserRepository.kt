package com.example.demo

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int> {
}