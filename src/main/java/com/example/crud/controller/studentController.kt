package com.example.crud.controller

import com.example.crud.DTO.studentReqDto
import com.example.crud.DTO.studentResponseDTO
import com.example.crud.entity.Student
import com.example.crud.repository.StudentRepo
import com.example.crud.service.StudentService
import jakarta.validation.Valid
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




        // Create Student
        @PostMapping("/add")
        fun createStudent(
            @Valid @RequestBody studentDto: studentReqDto
        ): ResponseEntity<studentResponseDTO> {

            // Convert Request DTO -> Entity
            val student = mapToEntity(studentDto)

            // Save Entity
            val savedStudent = studentRepo.save(student)

            // Convert Entity -> Response DTO
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapToDto(savedStudent))
        }

        // Get Student by Id
        @GetMapping("/get/{id}")
        fun getStudent(
            @PathVariable id: Long
        ): ResponseEntity<studentResponseDTO> {

            val student = studentRepo.findByIdAndDeletedFalse(id)
                ?: return ResponseEntity.notFound().build()

            return ok(mapToDto(student))
        }

        // Get All Students
        @GetMapping
        fun getAllStudents(): ResponseEntity<List<studentResponseDTO>> {

            val students = studentRepo.findAllByDeletedFalse()

            if (students.isEmpty()) {
                return ResponseEntity.noContent().build()
            }

            val response = students.map { mapToDto(it) }

            return ok(response)
        }

        // Update Student
        @PutMapping("/{id}")
        fun updateStudent(
            @PathVariable id: Long,
            @RequestBody studentDto: studentReqDto
        ): ResponseEntity<studentResponseDTO> {

            val student = studentRepo.findByIdAndDeletedFalse(id)
                ?: return ResponseEntity.notFound().build()

            student.name = studentDto.Name
            student.subject = studentDto.subject
            student.age = studentDto.age
            student.mail = studentDto.mail

            val updatedStudent = studentRepo.save(student)

            return ok(mapToDto(updatedStudent))
        }

        // Soft Delete Student
        @PatchMapping("/delete-soft/{id}")
        fun softDeleteStudent(
            @PathVariable id: Long
        ): ResponseEntity<Void> {

            val student = studentRepo.findByIdAndDeletedFalse(id)
                ?: return ResponseEntity.notFound().build()

            student.deleted = true
            studentRepo.save(student)

            return ResponseEntity.noContent().build()
        }

        // Hard Delete Student
        @DeleteMapping("/{id}")
        fun deleteStudent(
            @PathVariable id: Long
        ): ResponseEntity<Void> {

            return if (studentRepo.existsById(id)) {
                studentRepo.deleteById(id)
                ResponseEntity.noContent().build()
            } else {
                ResponseEntity.notFound().build()
            }
        }
    }


 fun mapToEntity(studentReqDto: studentReqDto): Student {
        return Student(
            id = studentReqDto.id,
            name = studentReqDto.Name,
            subject = studentReqDto.subject,
            age = studentReqDto.age,
            mail = studentReqDto.mail
        )
    }


     fun mapToDto(student: Student): studentResponseDTO {
        return studentResponseDTO(
            id = student.id,
            name = student.name,
            subject = student.subject,
            age = student.age,
            mail = student.mail,
            message = "Student fetched successfully"
        )
    }













