package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public Student saveStudent(Student student){
        students.add(student);
        return student;
    }

}
