package com.example.crud.controller

import com.example.crud.entity.Student
import com.example.crud.service.StudentService

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Component//THis is optional to use in this case e since we're already using @RestController
@RestController
@RequestMapping("/api/student")
class StudentController(  private val studentService: StudentService   ){ //constructor DI unlike java





    @PostMapping("/add")
    fun createStudent(@RequestBody  student: Student) : Student {
       return  studentService.create(student)

    }

    fun updateStudent(student: Student): Student {
        return student

    }

    fun deleteStudent(student: Student): Student {
        return student
    }

    fun readStudent(student: Student): Student {
        return student
    }

}