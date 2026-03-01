package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entity.Student;
import com.example.springsecurityjwt.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ArrayList<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentsById(@PathVariable Integer id ){
        return studentService.getStudentsById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

}
