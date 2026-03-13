package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entity.Student;
import com.example.springsecurityjwt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Student> getStudentsById(@PathVariable Long id ){
        return studentService.getStudentsById(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

}
