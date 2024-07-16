package com.example.impl_haitt_demo_ss1.repositories;

import com.example.impl_haitt_demo_ss1.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void updateStudent(Student student, long id);
}
