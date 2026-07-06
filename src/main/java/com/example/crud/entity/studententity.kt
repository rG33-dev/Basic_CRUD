package com.example.crud.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity//managed by spring JPA not by sping IOC container
@Table(name = "cruddb")


data class Student

    (
    @Id
    var id: Int = 0,//to tell primary key


    var name: String ="name1",
    var age: Int = 22,
    var mail: String = "name@mail.com",
    var subject: String = "none",
    var deleted: Boolean = false,


    ) {

}