package com.example.BookApplication.Repository;

import com.example.BookApplication.Dto.StudentDTO;
import com.example.BookApplication.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student>findByDepartment(String department);

    Student findByEmail(String email);

    List<Student>findByNameContaining(String name);


}
