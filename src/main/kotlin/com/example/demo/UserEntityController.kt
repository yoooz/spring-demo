package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path = ["/userentity"])
class UserEntityController {
    @Autowired
    lateinit var userEntityRepository: UserEntityRepository

    @GetMapping(path = ["/add"])
    @ResponseBody fun addNewUser(@RequestParam name: String, @RequestParam email: String): String {
        val entity = UserEntity()
        entity.name = name
        entity.email = email
        userEntityRepository.save(entity)
        return "Saved"
    }

    @GetMapping(path = ["/all"])
    @ResponseBody fun getAllUserEntities(): Iterable<UserEntity> {
        return userEntityRepository.findAll()
    }
}