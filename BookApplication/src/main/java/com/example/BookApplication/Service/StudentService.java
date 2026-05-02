package com.example.BookApplication.Service;


import com.example.BookApplication.Dto.StudentDTO;
import com.example.BookApplication.Model.Student;
import com.example.BookApplication.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student>getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElse(null);
    }


    public String addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setDepartment(studentDTO.getDepartment());
        studentRepository.save(student);
        return "Student Added Successfully!";
    }

    public String updateStudent(int id, StudentDTO studentDTO) {
        if (!studentRepository.existsById(id))
            return "No Student Exists with the Given Id!";
        Student student = studentRepository.findById(id).get();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setDepartment(studentDTO.getDepartment());
        studentRepository.save(student);
        return "Student Updated Successfully!";
    }


    public String deleteStudent(int id) {
        if (!studentRepository.existsById(id))
            return "No Student Exists with the Given Id!";
        studentRepository.deleteById(id);
        return "Student Deleted Successfully!";
    }

    public List<Student>getStudentByDepartment(String department){
        List<Student> studentList=studentRepository.findByDepartment(department);
        if(studentList.isEmpty())
            return new ArrayList<>();
        return studentList;
    }

    public Student getStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public List<Student>searchStudentByName(String name){

        List<Student>studentList=studentRepository.findByNameContaining(name);

        if (studentList.isEmpty())
            return new ArrayList<>();
        return studentList;
    }




}
