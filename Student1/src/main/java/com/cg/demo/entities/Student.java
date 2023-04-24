package com.cg.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int student_Id;
	@NotEmpty
	private String studentName;
	private int age;
	private String gender;
	@NotEmpty
	@Size(min = 10,max = 10)
	private String student_Phone;
	@Email
	private String email;
	@NotEmpty
	private String location;
	
}
