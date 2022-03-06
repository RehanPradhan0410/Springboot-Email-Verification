package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Module;
import com.example.spring.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.converter.ModuleConverter;
import com.example.spring.dto.ModuleDTO;

@Service
public class ModuleService {
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private ModuleConverter moduleConverter;

	public Module addModule(ModuleDTO dto) {
		return moduleRepository.save(moduleConverter.dtoToEntity(dto));
	}

	public List<Module> getModules() {
		return moduleRepository.findAll();
	}

	public Module getModuleById(int id) {
		return moduleRepository.findById(id).orElse(null);
	}

	public Module updateModule(ModuleDTO dto) {

		Module module = moduleConverter.dtoToEntity(dto);
		Module prevModule = moduleRepository.findById(module.getId()).orElse(null);

		if (prevModule == null)
			throw new NullPointerException();

		prevModule.setName(module.getName());
		prevModule.setCreditHours(module.getCreditHours());

		return moduleRepository.save(prevModule);
	}

	public String deleteModule(int id) {
		moduleRepository.deleteById(id);
		return "Module Removed";
	}

}
