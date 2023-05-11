package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.bean.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> listAll(){
		return repository.findAll();
	}
	
	public void  create(Student stud) {
		repository.save(stud);
	
	}
	public Student updateid(Integer id) {
		return repository.findById(id).get();
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
