package com.nsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.nsk.entity.Student;
import com.nsk.repo.StudentRepo;
@RestController
public class StudentController {
	@Autowired
	private StudentRepo repo;
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		Student s=repo.save(student);
		return s;
	}
	@DeleteMapping("/delete/{stdid}")
	public void deleteStudent(@PathVariable int   stdid) {
		repo.deleteById(stdid);
	}
	@GetMapping("/view/{stdid}")
	public Student getStudent(@PathVariable int stdid) {
		Student st=repo.findById(stdid).get();
		return st;
	}
	@GetMapping("/viewall")
	public List<Student> getAll(){
		List<Student> ls=repo.findAll();
		return ls;
	}
	@PutMapping("/update/{stdid}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int stdid) {
		Student std1=repo.findById(stdid).get();
		std1.setStdname(student.getStdname());
		std1.setCourse(student.getCourse());
		std1.setFee(student.getFee());
		return repo.save(std1);
		
    	
    }
	
}

































