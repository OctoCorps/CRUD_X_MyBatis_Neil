package com.it1311l.uap.registrationapi.repository;


import com.it1311l.uap.registrationapi.model.Attendee;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RegistrationMybatisRepository {

	@Insert("INSERT INTO attendees(firstName, middleName, lastName, course, age) " +
            "VALUES (#{firstName}, #{middleName}, #{lastName}, #{course}, #{age})")
int insert(Attendee attendee);


    @Update("UPDATE attendees SET surveyEligibilityTag = true WHERE course = 'BSIT'")
    void markBSITAttendeesEligible();

    @Select("SELECT * FROM attendees WHERE surveyEligibilityTag = true")
    List<Attendee> findEligibleAttendees();

    @Delete("DELETE FROM attendees WHERE attendeeId = #{id}")
    void deleteAttendeeById(String id);
    
    
    @Select("SELECT * FROM attendees")
    List<Attendee> findAll();
}
