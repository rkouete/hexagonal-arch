package com.tech4life.infrastructure.immemorydbadapter;

import com.tech4life.domain.model.Student;
import com.tech4life.domain.port.out.Students;
import com.tech4life.infrastructure.immemorydbadapter.entity.StudentEntity;
import com.tech4life.infrastructure.immemorydbadapter.entity.StudentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StudentsInMemory implements Students {

    StudentRepository repository = new StudentRepository();

    @Override
    public Student add(Student student) {
        var studentFromBD = repository.add(StudentEntity.fromDomain(student)).toDomain();
        return studentFromBD;
    }

    @Override
    public Map<String, Student> getAll() {
        return repository.getAll().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toDomain()));
    }
}
