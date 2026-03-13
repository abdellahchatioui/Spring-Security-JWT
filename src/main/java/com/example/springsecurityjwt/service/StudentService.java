package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Student;
import com.example.springsecurityjwt.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentsById(Long id){
        return studentRepo.findById(id);
    }

    public Student saveStudent(Student student){
        studentRepo.save(student);;
        return student;
    }


}
