package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student getStudentsById(Integer id){
        return students.get(id);
    }

    public Student saveStudent(Student student){
        students.add(student);
        return student;
    }


}
