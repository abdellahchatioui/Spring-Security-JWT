package com.example.springsecurityjwt.repo;


import com.example.springsecurityjwt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
