package edu.mum.cs.cs425.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	public Student()
	{
	}	
	public Student(String studentNumber, String firstName, String middleName, String lastName, double cGPA,
			LocalDate dateOfEnrollment, Transcript transcript) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cGPA = cGPA;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "snumber", nullable = false)
	private String studentNumber;
	
	@Column(name ="fname", nullable = false)
	private String firstName;
	
	@Column(name ="mname", nullable =true)
	private String middleName;
	
	@Column(name ="lname", nullable =false)
	private String lastName;
	
	@Column(name ="cgpa", nullable = true)
	private double cGPA;
	
	@Column(name = "dateofenrollment")
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "transcript_id")
	private Transcript transcript;

	@ManyToOne
	@JoinColumn(name = "class_room_id")
	private ClassRoom classRoom;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	List<Course> courses = new ArrayList<>();
	
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getcGPA() {
		return cGPA;
	}

	public void setcGPA(double cGPA) {
		this.cGPA = cGPA;
	}

	public long getId() {
		return id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course)
	{
		this.courses.add(course);
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", cGPA=" + cGPA + ", dateOfEnrollment=" + dateOfEnrollment
				+ ", transcript=" + transcript + ", classRoom=" + classRoom + "]";
	}
	
	

}
