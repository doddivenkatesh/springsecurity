package com.springsecurity.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
import java.util.stream.Stream;
=======
>>>>>>> 19f2d9facef8610c7b3ffc5ffb35b4cfbd7da5ca

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

<<<<<<< HEAD
	private List<Student> students = Stream.of(
	        new Student(1, "Navin", 60),
	        new Student(2, "Kiran", 65)
	    ).collect(Collectors.toList());

=======
	 private List<Student> students = new ArrayList<>(
	            List.of(
	                    new Student(1, "Navin", 60),
	                    new Student(2, "Kiran", 65)
	            ));
>>>>>>> 19f2d9facef8610c7b3ffc5ffb35b4cfbd7da5ca


	    @GetMapping("/students")
	    public List<Student> getStudents() {
	        return students;
	    }

	    @GetMapping("/csrf-token")
	    public CsrfToken getCsrfToken(HttpServletRequest request) {
	        return (CsrfToken) request.getAttribute("_csrf");


	    }


	    @PostMapping("/students")
	    public Student addStudent(@RequestBody Student student) {
	        students.add(student);
	        return student;
	    }
}
