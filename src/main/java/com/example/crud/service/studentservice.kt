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


    fun getAllStudent(): List<Student> {
        return repo.findAll()
    }

    fun updateStudent(id: Long, studentReq: Student): Student? {
        val existingStudent = repo.findById(id).orElse(null)
            ?: return null

        existingStudent.name = studentReq.name
        existingStudent.id = id
        existingStudent.subject = studentReq.subject
        existingStudent.mail = studentReq.mail
        existingStudent.age = studentReq.age

        return repo.save(existingStudent)
    }

    fun deleteStudent(id: Long): Boolean {
        if (!repo.existsById(id)) {
            return false
        }

            repo.deleteById(id)
        return true
    }
}



