package com.example.crud.controller

import com.example.crud.entity.Student
import com.example.crud.repository.StudentRepo
import com.example.crud.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import java.util.Optional


@Component//THis is optional to use in this case e since we're already using @RestController
@RestController
@RequestMapping("/api/student")
class StudentController(
    private val studentService: StudentService, private val studentRepo: StudentRepo
)//constructor DI unlike java


{


    @PostMapping("/add")
    fun createStudent(@RequestBody student: Student): Student {

        student.deleted = false//check

        val studentResp = studentService.create(student)

        return studentResp

    }

    @GetMapping("/get/{id}")    //here we cant hardcode id like id=1, cause it'll fetch constant values
    //so use path variable here using @Pathvaraible
    fun getStudent(@PathVariable id: Long, student: Student): ResponseEntity<Student> {
        val studentResponse = studentRepo.findByIdAndDeletedFalse(id)



       return ResponseEntity(studentResponse, HttpStatus.OK)
    }




    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentRepo.findAllByDeletedFalse()

        return if (students.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(students)
        }
    }

    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long,
        @RequestBody studentReq: Student
    ): ResponseEntity<Student> {

        val student = studentRepo.findByIdAndDeletedFalse(id)
            ?: return ResponseEntity.notFound().build()


        student.name = studentReq.name
        student.age = studentReq.age
        student.mail = studentReq.mail

        student.subject = studentReq.subject
        student.deleted = false

        val updatedStudent = studentRepo.save(student)

        return ok(updatedStudent)




    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> = if (studentRepo.existsById(id)) {
        ResponseEntity.noContent().build()
    } else {
        ResponseEntity.notFound().build()
    }

    @PatchMapping("/delete-soft")
    fun softDeleteStudent(@PathVariable   id: Long): ResponseEntity<Void> {
        val student = studentRepo.findByIdAndDeletedFalse(id)
            ?: return ResponseEntity.notFound().build()

        student.deleted = true
        studentRepo.save(student)

        return ResponseEntity.noContent().build()
    }
}












