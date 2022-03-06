package com.example.spring.converter;

import java.util.List;

import com.example.spring.dto.ClassroomDTO;
import com.example.spring.model.Classroom;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClassroomConverter {

	public ClassroomDTO entityToDto(Classroom classroom) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(classroom, ClassroomDTO.class);
	}

	public List<ClassroomDTO> entityToDto(List<Classroom> classrooms) {
		return classrooms.stream().map(this::entityToDto).toList();
	}

	public Classroom dtoToEntity(ClassroomDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Classroom.class);
	}

	public List<Classroom> dtoToEntity(List<ClassroomDTO> dtos) {
		return dtos.stream().map(this::dtoToEntity).toList();
	}

}
