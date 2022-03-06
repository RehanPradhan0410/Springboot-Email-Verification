package com.example.spring.service;

import java.util.List;

import javax.mail.MessagingException;

import com.example.spring.model.Student;
import com.example.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.converter.StudentConverter;
import com.example.spring.dto.StudentDTO;

@Service
public class StudentService {
	@Autowired
	private EmailService emailService;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentConverter studentConverter;

	public Student addStudent(StudentDTO dto) throws MessagingException {
		Student student = studentRepository.save(studentConverter.dtoToEntity(dto));
		emailService.sendmail(student.getEmail(), student.getId());
		return student;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	public boolean verifyStudent(int id) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null)
			return false;
		student.setVerified(true);
		studentRepository.save(student);
		return true;
	}

	public Student updateStudent(StudentDTO dto) {

		Student student = studentConverter.dtoToEntity(dto);
		Student prevStudent = studentRepository.findById(student.getId()).orElse(null);

		if (prevStudent == null)
			throw new NullPointerException();

		prevStudent.setAge(student.getAge());
		prevStudent.setName(student.getName());
		prevStudent.setVerified(student.isVerified());

		return studentRepository.save(prevStudent);
	}

	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student Removed";
	}

}
