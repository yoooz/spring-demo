package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path = ["/userentity"])
class UserController {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserController::class.java.simpleName)
    }

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping(path = ["/add"])
    @ResponseBody fun addNewUser(
        @RequestParam name: String,
        @RequestParam email: String,
        @RequestParam ds: String?
    ): String {
        LOGGER.info("[call]")
        val entity = User()
        entity.name = name
        entity.email = email
        userRepository.save(entity)
        return "Saved"
    }

    @GetMapping(path = ["/all"])
    @ResponseBody fun getAllUserEntities(
        @RequestParam ds: String?
    ): Iterable<User> {
        LOGGER.info("[call]")
        return userRepository.findAll()
    }
}