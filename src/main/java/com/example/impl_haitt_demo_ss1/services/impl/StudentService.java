package com.example.impl_haitt_demo_ss1.services.impl;

import com.example.impl_haitt_demo_ss1.models.Student;
import com.example.impl_haitt_demo_ss1.repositories.IStudentRepository;
import com.example.impl_haitt_demo_ss1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  implements IStudentService {
    @Autowired
    IStudentRepository studentRepository ;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void updateStudent(Student student, long id) {
        studentRepository.updateStudent(student,id);
    }
}
