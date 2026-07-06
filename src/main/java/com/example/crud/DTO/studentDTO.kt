package com.example.crud.DTO

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.springframework.stereotype.Component



data class studentReqDto(

    @field:NotBlank
    val id : Int,

    @field:NotBlank
    val Name :String,


    val subject :String,


//    @field:Min(value = 18)
//    @field:NotBlank(message = "Must be over 15"")
    @field:Min(value = 18, message = "Age must be at least 18")
    val age :Int,

    val mail :String

){
}


data class studentResponseDTO(

    @field:NotBlank
    val id: Int,
    @field:NotBlank
    val name: String,
    val subject: String
    ,@field:Min(value = 18)
    val age: Int,
    val mail: String,
    val message: String
){

}