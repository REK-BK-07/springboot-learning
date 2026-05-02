package com.example.BookApplication.Repository;

import com.example.BookApplication.Dto.StudentDTO;
import com.example.BookApplication.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
