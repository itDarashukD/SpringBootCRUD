package com.darashuk.project.student.controller;

import com.darashuk.project.student.entity.Student;
import com.darashuk.project.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAll() {
        return studentService.getAllStudent();
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping(value = "{name}")
    public Optional<Student> findStudentByName(@PathVariable("name") String name) {
        return studentService.getByName(name);
    }

    @PostMapping(value = "{studentId}")
    public void updateStudent(@PathVariable Long studentId
                                ,@RequestParam(required = false)String name,
                                 @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);

    }

    @DeleteMapping(value = "{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudentById(studentId);

    }
}
