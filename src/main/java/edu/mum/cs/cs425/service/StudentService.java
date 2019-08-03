package edu.mum.cs.cs425.service;

import java.util.List;

import edu.mum.cs.cs425.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student readStudentById(Long id);
}
