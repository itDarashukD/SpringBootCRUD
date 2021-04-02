package com.darashuk.project.student.service;

import com.darashuk.project.student.entity.Student;
import com.darashuk.project.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> student1 = studentRepository.findByEmail(student.getEmail());
        Optional<Student> student2 = studentRepository.findByName(student.getName());

        if (student1.isPresent()) {
            throw new IllegalStateException("Email is present");
        }
        if (student2.isPresent()) {
            throw new IllegalStateException("Name is present");
        }
        studentRepository.save(student);
    }

    public Optional<Student> getByName(String name) {
        return studentRepository.findByName(name);
    }


    public void deleteStudentById(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (exist) {
            studentRepository.deleteById(studentId);
        } else throw new IllegalStateException("student with id = " + studentId + " do not exist");
    }
@Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student not fined"));
        student.setName(name);
        student.setEmail(email);
    }
}


