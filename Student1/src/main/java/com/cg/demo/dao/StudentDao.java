package com.cg.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.entities.Student;

@Repository("sd")
public interface  StudentDao extends JpaRepository<Student, Integer>{

	
}
