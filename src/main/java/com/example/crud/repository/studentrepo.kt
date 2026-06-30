package com.example.crud.repository

import com.example.crud.entity.Student
import org.springframework.stereotype.Component


@Component
class StudentRepo {


    fun saveStudent(student: Student) : Student
    {

        return student


    }

}