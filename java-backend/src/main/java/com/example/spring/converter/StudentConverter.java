package com.example.spring.converter;

import java.util.List;

import com.example.spring.dto.StudentDTO;
import com.example.spring.model.Student;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
	public StudentDTO entityToDto(Student student) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(student, StudentDTO.class);
	}

	public List<StudentDTO> entityToDto(List<Student> student) {
		return student.stream().map(this::entityToDto).toList();
	}

	public Student dtoToEntity(StudentDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Student.class);
	}

	public List<Student> dtoToEntity(List<StudentDTO> dtos) {
		return dtos.stream().map(this::dtoToEntity).toList();
	}
}
