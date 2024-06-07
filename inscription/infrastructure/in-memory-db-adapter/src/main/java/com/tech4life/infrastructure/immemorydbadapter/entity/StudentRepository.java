package com.tech4life.infrastructure.immemorydbadapter.entity;

import com.tech4life.domain.model.Student;
import org.apache.logging.log4j.core.util.UuidUtil;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    Map<String, StudentEntity> students = new HashMap<>();

    public StudentEntity add(StudentEntity student) {
        if (student != null) {
            student.setId(UuidUtil.getTimeBasedUuid().toString());
            students.put(student.getId(), student);
        }
        return student;
    }

    public Map<String, StudentEntity> getAll() {
        return students;
    }
}
