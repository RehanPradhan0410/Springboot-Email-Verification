package com.example.spring.converter;

import java.util.List;

import com.example.spring.dto.ModuleDTO;
import com.example.spring.model.Module;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModuleConverter {

	public ModuleDTO entityToDto(Module module) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(module, ModuleDTO.class);
	}

	public List<ModuleDTO> entityToDto(List<Module> modules) {
		return modules.stream().map(this::entityToDto).toList();
	}

	public Module dtoToEntity(ModuleDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Module.class);
	}

	public List<Module> dtoToEntity(List<ModuleDTO> dtos) {
		return dtos.stream().map(this::dtoToEntity).toList();
	}

}
