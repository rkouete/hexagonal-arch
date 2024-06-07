package com.tech4life.inscription.configuration;

import com.tech4life.domain.port.in.EnrollmentCoordinator;
import com.tech4life.domain.port.out.Students;
import com.tech4life.domain.serviceadapter.EnrollmentCoordinatorImpl;
import com.tech4life.infrastructure.immemorydbadapter.StudentsInMemory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EnrollmentCoordinator enrollmentCoordinator(){
        return new EnrollmentCoordinatorImpl(students());
    }

    @Bean
    public Students students(){
        return new StudentsInMemory();
    }
}
