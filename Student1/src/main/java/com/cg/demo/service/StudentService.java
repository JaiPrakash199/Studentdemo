package com.cg.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.StudentDao;
import com.cg.demo.entities.Student;
import com.demo.student.exceptions.IdNotMatchedException;
import com.demo.student.exceptions.NoStudentFoundException;
import com.demo.student.exceptions.StudentIdNotFoundException;

@Service("ss")
public class StudentService {

	@Autowired
	StudentDao sd;

	public String insertStudent(@Valid Student stu) {
		Student dbTr = sd.save(stu);
		return "Added Successfully with Id:" + dbTr.getStudent_Id();
	}

	public String updateStudent(int id, @Valid Student stu) {
		if (id == stu.getStudent_Id()) {
			if (sd.existsById(id)) {
				Student updr = sd.save(stu);
				return "Updated Successfully for id:" + updr.getStudent_Id();
			} else
				throw new StudentIdNotFoundException("Student Not found for Id :" + id);
		}
		throw new IdNotMatchedException("Id is not matched in Path Variable and in the request body :" + id);
	}

	public Student findByStudentId(int id) {
		Optional<Student> op = sd.findById(id);
		if (op.isPresent())
			return op.get();
		else
			throw new StudentIdNotFoundException("Student Not found for Id :" + id);
	}

	public List<Student> findAll() {
		List<Student> list = sd.findAll();
		if (list.isEmpty())
			throw new NoStudentFoundException("No Student Found ");
		return list;
	}
	
	public String deleteById(int id) {
		if (sd.existsById(id)) {
			sd.deleteById(id);
			return "Deleted Successfully for Id:" + id;
		}
		throw new StudentIdNotFoundException("Doctor Not found for Id :" + id);
	}

}
