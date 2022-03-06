package com.example.spring.dto;

import com.example.spring.model.Classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
	private String name;
	private String creditHours;
	private Classroom classroom;
}
