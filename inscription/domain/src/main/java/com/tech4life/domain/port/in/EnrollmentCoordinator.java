package com.tech4life.domain.port.in;

import com.tech4life.domain.model.Clazz;
import com.tech4life.domain.model.Enrollment;
import com.tech4life.domain.model.Student;

import java.util.Map;

public interface EnrollmentCoordinator {
    Enrollment enroll(Student student, Clazz clazz);

    Map<String, Student> getSchoolPopulation();
}
