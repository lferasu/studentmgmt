package edu.mum.cs.cs425.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.model.Student;
import edu.mum.cs.cs425.repository.StudentRepository;
import edu.mum.cs.cs425.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll(Sort.by("snumber"));
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student readStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	

}
