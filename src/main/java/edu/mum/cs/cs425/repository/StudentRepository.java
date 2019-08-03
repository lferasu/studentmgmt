package edu.mum.cs.cs425.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
