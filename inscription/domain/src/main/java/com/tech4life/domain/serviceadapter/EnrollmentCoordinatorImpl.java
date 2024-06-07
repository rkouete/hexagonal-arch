package com.tech4life.domain.serviceadapter;

import com.tech4life.domain.model.Clazz;
import com.tech4life.domain.model.Enrollment;
import com.tech4life.domain.model.Student;
import com.tech4life.domain.port.in.EnrollmentCoordinator;
import com.tech4life.domain.port.out.Students;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class EnrollmentCoordinatorImpl implements EnrollmentCoordinator {

    private final Logger LOGGER = LogManager.getLogger(getClass());

    private final Students students;

    public EnrollmentCoordinatorImpl(Students students) {
        this.students = students;
    }

    @Override
    public Enrollment enroll(Student student, Clazz clazz) {
        LOGGER.debug("Start enrolling student {} {}",
                student.lastName(), student.firstName());
        student = students.add(student);
        LOGGER.info("{} {} enrolled successfully!!", student.lastName(), student.firstName());
        return new Enrollment(student, clazz);
    }

    @Override
    public Map<String, Student> getSchoolPopulation() {
        return students.getAll();
    }
}
