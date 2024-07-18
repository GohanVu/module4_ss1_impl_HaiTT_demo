package com.example.impl_haitt_demo_ss1.repositories.impl;

import com.example.impl_haitt_demo_ss1.models.Student;
import com.example.impl_haitt_demo_ss1.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> findAll() {
        //CreateQuery va CreateNameQuery viet bang HQL: Hibernate query language
        //NativeQuery: SQL
        List<Student> students1 = BaseRepository.entityManager.createQuery("from student", Student.class).getResultList();
        return students1;
    }

    @Override
    public void save(Student student) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        //Phan biet persist va merge
        BaseRepository.entityManager.merge(student);
        transaction.commit();
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
