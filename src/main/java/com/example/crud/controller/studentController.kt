package com.example.crud.controller

import com.example.crud.entity.Student
import com.example.crud.repository.StudentRepo
import com.example.crud.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*


@Component//THis is optional to use in this case e since we're already using @RestController
@RestController
@RequestMapping("/api/student")
class StudentController(
    private val studentService: StudentService, private val studentRepo: StudentRepo
)//constructor DI unlike java


{


    @PostMapping("/add")
    fun createStudent(@RequestBody student: Student): Student {
        return studentService.create(student)

    }

    @GetMapping("/get/{id}")    //here we cant hardcode id like id=1, cause it'll fetch constant values
    //so use path variable here using @Pathvaraible
    fun getStudent(@PathVariable id: Long, student: Student): ResponseEntity<Student> {
        val studentResponse = studentRepo.findById(id)

        return if (studentResponse.isPresent) {
            ok(studentResponse.get())
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)

        }
    }

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentService.getAllStudent()

        return if (students.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(students)
        }
    }

    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long, @RequestBody studentReq: Student
    ): ResponseEntity<Student> = studentService.updateStudent(id, studentReq)?.let {
        ResponseEntity.ok(it)
    } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> = if (studentService.deleteStudent(id)) {
        ResponseEntity.noContent().build()
    } else {
        ResponseEntity.notFound().build()
    }
}












