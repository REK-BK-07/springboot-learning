package com.example.BookApplication.Controller;

import com.example.BookApplication.Dto.StudentDTO;
import com.example.BookApplication.Model.Student;
import com.example.BookApplication.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllstudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentByid(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody StudentDTO studentDto){
       return studentService.addStudent(studentDto);
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody StudentDTO studentDto){
        return studentService.updateStudent(id,studentDto);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/student/department/{department}")
    public List<Student>studentList(@PathVariable String department){
        return studentService.getStudentByDepartment(department);
    }

    @GetMapping("/student/email/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/student/name/{name}")
    public List<Student>getStudentByName(@PathVariable String name){
        return studentService.searchStudentByName(name);
    }






}
