package com.joghar.controller;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joghar.model.Student;
import com.joghar.repository.StudentRepository;
import com.joghar.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired StudentRepository studentRepository; 
	@Autowired StudentService studentService;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString());
		Student student2 =  studentRepository.save(student);
		return student2;
	}
	
	@GetMapping("/getAll")
	public Iterable<Student> getAll() {
		Iterable<Student> students = studentRepository.findAll();
		return students;
	}
	
	@GetMapping("/get/{id}")
	public Student get(@PathVariable String id) {
		return studentRepository.findById(id).get();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		studentRepository.deleteById(id);
	}
	
	@PostMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/getLikeByName/{value}")
	public List<Student> getLikeByName(@PathVariable String value) {
		return studentService.likeByName(value);
	}
}
