package com.tech4life.infrastructure.immemorydbadapter.entity;

import com.tech4life.domain.model.Student;

public class StudentEntity {
    private String id;
    private String firstName;
    private String lastName;


    public StudentEntity(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static StudentEntity fromDomain(Student student) {
        return new StudentEntity(student.id(), student.firstName(), student.lastName());
    }

    public Student toDomain() {
        return new Student(this.getId(), firstName, lastName);
    }

}
