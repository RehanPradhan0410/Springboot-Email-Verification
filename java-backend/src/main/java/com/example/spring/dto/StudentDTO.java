package com.example.spring.dto;

import com.example.spring.model.Classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private String name;
	private String email;
	private int age;
	private Classroom classroom;
}
