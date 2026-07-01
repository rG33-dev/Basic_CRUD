package com.example.crud.service

import com.example.crud.entity.Student
import com.example.crud.repository.StudentRepo
import org.springframework.stereotype.Service


@Service
class StudentService(private val repo : StudentRepo) {

    fun create(student: Student) : Student {


       val requestByUser = repo.save(student)
        return requestByUser

    }
}



