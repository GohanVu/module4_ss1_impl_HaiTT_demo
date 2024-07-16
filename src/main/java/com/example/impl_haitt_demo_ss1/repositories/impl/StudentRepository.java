package com.example.impl_haitt_demo_ss1.repositories.impl;

import com.example.impl_haitt_demo_ss1.models.Student;
import com.example.impl_haitt_demo_ss1.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L,"HaiTT1","QN",9.0f));
        students.add(new Student(2L,"HaiTT2","QN",8.0f));
        students.add(new Student(3L,"HaiTT3","QN",7.0f));
        students.add(new Student(4L,"HaiTT4","QN",6.0f));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size()-1).getId()+1);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student s : students){
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student, long id) {
        for(Student s : students){
            if(s.getId() == id ){
                s.setName(student.getName());
                s.setAddress(student.getAddress());
                s.setScore(student.getScore());
            }
        }
    }
}
