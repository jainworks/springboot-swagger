package com.coaching.coaching.controller;


import com.coaching.coaching.model.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.coaching.coaching.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping("/add")
    @ApiOperation(value = "Add new Student.")
    public String saveStudent(@RequestBody Student student) {
        repository.save(student);
        return "Student added successfully with id: " + student.getSid();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findAll")
    @ApiOperation(value = "Returns details of all Students.")
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @GetMapping("/findStudent/{id}")
    @ApiOperation(value = "Returns details of specific Student by Id entered.")
       public Optional<Student> getStudentById(@PathVariable int id) {
        return repository.findById(id);
    }

    @ApiOperation(value = "Delete student by Id entered.")
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Student with " + id + " successfully deleted";

    }
}
