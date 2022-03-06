package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Classroom;
import com.example.spring.model.Student;
import com.example.spring.model.Module;
import com.example.spring.repository.ClassroomRepository;
import com.example.spring.repository.StudentRepository;
import com.example.spring.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.converter.ClassroomConverter;
import com.example.spring.dto.ClassroomDTO;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomRepository classroomRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ClassroomConverter classroomConverter;

	public Classroom addClassroom(ClassroomDTO dto) {
		return classroomRepository.save(classroomConverter.dtoToEntity(dto));
	}

	public List<Classroom> getClassrooms() {
		return classroomRepository.findAll();
	}

	public Classroom getClassroomById(int id) {
		return classroomRepository.findById(id).orElse(null);
	}

	public Classroom updateClassroom(ClassroomDTO dto) {
		Classroom classroom = classroomConverter.dtoToEntity(dto);
		Classroom prevClassroom = classroomRepository.findById(classroom.getId()).orElse(null);

		if (prevClassroom == null)
			throw new NullPointerException();

		prevClassroom.setLocation(classroom.getLocation());
		prevClassroom.setName(classroom.getName());

		return classroomRepository.save(prevClassroom);
	}

	public String deleteClassroom(int id) {
		classroomRepository.deleteById(id);
		return "Classroom Removed";
	}

	public Classroom addStudentToClassroom(int classroomId, int studentId) {

		Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);

		if (student == null || classroom == null)
			throw new NullPointerException();

		classroom.getStudents().add(student);

		return classroomRepository.save(classroom);

	}

	public Classroom addModuleToClassroom(int classroomId, int moduleId) {

		Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
		Module module = moduleRepository.findById(moduleId).orElse(null);

		if (module == null || classroom == null)
			throw new NullPointerException();

		classroom.getModules().add(module);

		return classroomRepository.save(classroom);

	}
}