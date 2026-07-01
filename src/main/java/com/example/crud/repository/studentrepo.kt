package com.example.crud.repository

import com.example.crud.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component//optional
interface StudentRepo : JpaRepository<Student, Long> { //instead of manually writing all functions like save, delete, JPA repo privides all these inbuilt functios.


    //USE JPA REPO IN-BUILT TO IMPLEMENT ALL CHANGES IN DATABASE
    //Changed class to interface to use jpa methods.
    //Why we dont need to override abstract methods(implemntation) in this file
    //cause SPRING JPA handles all this by its own
}


