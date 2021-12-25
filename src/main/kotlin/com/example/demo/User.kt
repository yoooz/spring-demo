package com.example.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "user_t")
class User {
    @Id
    @Column(name = "id")
    var id: Int = 0

    @Column(name = "name")
    var name: String = ""

    @Column(name = "email")
    var email: String = ""
}