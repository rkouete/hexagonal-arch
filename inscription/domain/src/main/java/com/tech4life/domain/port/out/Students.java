package com.tech4life.domain.port.out;

import com.tech4life.domain.model.Student;

import java.util.Map;

//repository (liste de la classe)
public interface Students {
    Student add(Student student);

    Map<String, Student> getAll();
}
