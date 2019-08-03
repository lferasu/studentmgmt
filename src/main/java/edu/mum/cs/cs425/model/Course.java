package edu.mum.cs.cs425.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "coursename")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_student", 
	joinColumns = @JoinColumn(name ="course_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
	List<Student> students = new ArrayList<>();
	
	public Course()
	{
		
	}
	public Course(String name)
	{
		this.name =name;
	}
	
	public Course(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	

}
