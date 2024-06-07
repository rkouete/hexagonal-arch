package com.tech4life.inscription.controller;

import com.tech4life.domain.port.in.EnrollmentCoordinator;
import com.tech4life.inscription.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentCoordinator enrollmentCoordinator;
    @PostMapping("/enrol")
    public ResponseEntity<?> enrollStudent(@RequestBody StudentRequest student){
        System.out.println("enrolling student");
        var enrollment = enrollmentCoordinator.enroll(student.toDomain(), null);
        System.out.println("Student enrolled successfully!!");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(enrollment);
    }

    @GetMapping("/school-population")
    public ResponseEntity<?> schoolPopulation(){
        var population = enrollmentCoordinator.getSchoolPopulation();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(population);
    }
}
