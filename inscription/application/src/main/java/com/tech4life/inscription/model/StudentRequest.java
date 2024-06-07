package com.tech4life.inscription.model;

import com.tech4life.domain.model.Student;

public record StudentRequest(String firstName, String lastName) {
    public Student toDomain() {
        return new Student(null, firstName, lastName);
    }
}
