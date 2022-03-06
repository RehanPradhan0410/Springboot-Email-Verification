
package com.example.spring.controller;

import java.util.List;

import javax.mail.MessagingException;

import com.example.spring.dto.StudentDTO;
import com.example.spring.model.Student;
import com.example.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin("*")
@RequestMapping(value = "/api/student")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student addStudent(@RequestBody StudentDTO dto) throws MessagingException {
		return studentService.addStudent(dto);
	}

	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/verify/{id}")
	public boolean verifyStudent(@PathVariable int id) {
		return studentService.verifyStudent(id);
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@PutMapping
	public Student updateStudent(@RequestBody StudentDTO dto) {
		return studentService.updateStudent(dto);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
}