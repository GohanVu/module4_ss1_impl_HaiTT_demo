package com.example.impl_haitt_demo_ss1.models;

import javax.persistence.*;

// Phan biet @Entity va @Table
@Entity(name = "student")
//@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name;
    private String address;
    private Float score ;

    public Student() {
    }

    public Student(Long id, String name, String address, Float score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public Student(String name, String address, Float score) {
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
