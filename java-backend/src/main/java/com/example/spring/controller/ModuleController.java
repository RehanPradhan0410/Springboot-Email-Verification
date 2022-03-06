package com.example.spring.controller;

import java.util.List;

import com.example.spring.dto.ModuleDTO;
import com.example.spring.model.Module;
import com.example.spring.service.ModuleService;
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
@RequestMapping(value = "/api/module")
@RestController
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@PostMapping
	public Module addModule(@RequestBody ModuleDTO dto) {
		return moduleService.addModule(dto);
	}

	@GetMapping
	public List<Module> getModules() {
		return moduleService.getModules();
	}

	@GetMapping("/{id}")
	public Module getModuleById(@PathVariable int id) {
		return moduleService.getModuleById(id);
	}

	@PutMapping
	public Module updateModule(@RequestBody ModuleDTO dto) {
		return moduleService.updateModule(dto);
	}

	@DeleteMapping("/{id}")
	public String deleteModule(@PathVariable int id) {
		return moduleService.deleteModule(id);
	}
}