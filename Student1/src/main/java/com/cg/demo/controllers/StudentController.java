package com.cg.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entities.Student;
import com.cg.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController {
	@Autowired
	StudentService studentsService;
	
	@PostMapping("/students")
	public ResponseEntity<String> addStudent(@Valid@RequestBody Student student) {
		String sr=studentsService.insertStudent(student);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(sr,HttpStatus.CREATED);
		return rEntity;
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<String> modifyStudent(@PathVariable ("id") int id, @Valid@RequestBody Student student) {
		String msg=studentsService.updateStudent(id,student);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		return rEntity;
	}
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") int id){
		Student sr =studentsService.findByStudentId(id);
		ResponseEntity<Student> rEntity=new ResponseEntity<Student>(sr,HttpStatus.OK);
		return rEntity;
	}
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable ("id")int id) {
		String sr=studentsService.deleteById(id);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(sr,HttpStatus.ACCEPTED);
		return rEntity;
	}
//	@Operation(summary = "Get Students List")
//	@GetMapping("/students")
//	public List<Student> fetchAllStudent(){
//		return ss.findAll();
//	}
//	@GetMapping("/students")
//	public String listStudent(Model model) {
//		model.addAttribute("students", studentsService.findAll());
//		return "students";
//	}
}
