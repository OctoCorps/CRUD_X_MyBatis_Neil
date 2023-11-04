package com.it1311l.uap.registrationapi.controller;

import com.it1311l.uap.registrationapi.model.Attendee;
import com.it1311l.uap.registrationapi.repository.RegistrationMybatisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@RestController
public class RegistrationController {

	 @Autowired
	    RegistrationMybatisRepository registrationRepo;
	
    @PostMapping("/event/register")
    public Attendee register(@RequestBody Attendee student) {
    	registrationRepo.insert(student);
        return student;
    }
    
    @GetMapping("/attendees")
    public List<Attendee> getAttendees() {
        return registrationRepo.findAll();
    }
    
    @PutMapping("/event/survey/eligibility")
    public List<Attendee> markBSITAttendeesEligible() {
        // Mark BSIT attendees as eligible for the survey (set surveyEligibilityTag to true)
        registrationRepo.markBSITAttendeesEligible();
        
        // Retrieve and return records with surveyEligibilityTag = true
        return registrationRepo.findEligibleAttendees();
    }
    
    @DeleteMapping("/event/registration/{id}")
    public void deleteAttendeeById(@PathVariable String id) {
        // Delete the record with the specified ID
        registrationRepo.deleteAttendeeById(id);
    }

    

}
