package com.example.crud.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.context.annotation.Primary


@Entity//managed by spring JPA not by sping IOC container
@Table(name = "StudentDB")


data class Student

    (
    @Id
    var id: Long,//to tell primary key


    var name: String,
    var age: Int,
    var mail :  String,
    var subject: String

) {

}