package com.example.spring.controller;

import java.util.List;

import com.example.spring.dto.ClassroomDTO;
import com.example.spring.model.Classroom;
import com.example.spring.service.ClassroomService;
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
@RequestMapping(value = "/api/classroom")
@RestController
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;

	@PostMapping
	public Classroom addClassroom(@RequestBody ClassroomDTO dto) {
		return classroomService.addClassroom(dto);
	}

	@GetMapping
	public List<Classroom> getClassrooms() {
		return classroomService.getClassrooms();
	}

	@GetMapping("/{id}")
	public Classroom getClassroomById(@PathVariable int id) {
		return classroomService.getClassroomById(id);
	}

	@PutMapping
	public Classroom updateClassroom(@RequestBody ClassroomDTO dto) {
		return classroomService.updateClassroom(dto);
	}

	@DeleteMapping("/{id}")
	public String deleteClassroom(@PathVariable int id) {
		return classroomService.deleteClassroom(id);
	}

	@PutMapping("/{cid}/students/{sid}")
	public Classroom addStudentToClassroom(@PathVariable int cid, @PathVariable int sid) {
		return classroomService.addStudentToClassroom(cid, sid);
	}

	@PutMapping("/{cid}/students/{mid}")
	public Classroom addModuleToClassroom(@PathVariable int cid, @PathVariable int mid) {
		return classroomService.addModuleToClassroom(cid, mid);
	}

}