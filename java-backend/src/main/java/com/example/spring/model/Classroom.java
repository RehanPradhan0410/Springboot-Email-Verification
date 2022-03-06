package com.example.spring.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classroom")
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;

	@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "clasroom_id", referencedColumnName = "id")
	private List<Student> students;

	@OneToMany(targetEntity = Module.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "clasroom_id", referencedColumnName = "id")
	private List<Module> modules;
}
