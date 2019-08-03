package edu.mum.cs.cs425;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.model.ClassRoom;
import edu.mum.cs.cs425.model.Course;
import edu.mum.cs.cs425.model.Student;
import edu.mum.cs.cs425.model.Transcript;
import edu.mum.cs.cs425.service.ClassRoomService;
import edu.mum.cs.cs425.service.CourseService;
import edu.mum.cs.cs425.service.StudentService;
import edu.mum.cs.cs425.service.TranscriptService;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {
  
	@Autowired
	StudentService studentService;
	
	@Autowired
	TranscriptService transcriptService;
	
	@Autowired
	ClassRoomService classRoomService;
	
	@Autowired 
	CourseService courseService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
       Transcript transcript1 = new Transcript("BS CS");
       Transcript transcript2 = new Transcript("MS CS");
       Transcript transcript3 = new Transcript("PHD CS");
   
	   Student student1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), transcript1);
	   Student student2 = new Student("000-61-0002", "Maria", "Lokova", "Martin", 3.99, LocalDate.of(2019, 5, 25), transcript2);
	   Student student3 = new Student("000-61-0003", "Chris", "Jhon", "Barry", 3.65, LocalDate.of(2018, 7, 11), transcript3);
	   

	   // Lets create a s and assign them a course (many to many)
	   List<Student> fppStudents= Arrays.asList(student1,student2,student3);
	   List<Student> mppStudents = Arrays.asList(student1,student2);
	   
	   Course fpp = new Course("FPP");
	   Course mpp = new Course ("MPP");
	   
	   assignStudentsToCourse(fpp, fppStudents);
	   assignStudentsToCourse(mpp, mppStudents);
	   
	   saveCourse(fpp);
	   saveCourse(mpp);
	   
	   
	   // Create 2 new Transcripts
       Transcript tr1 = new Transcript("BS Computer Science");
       Transcript tr2 = new Transcript("MS Computer Science");
      

       // Create 2 new students
       Student s1 = new Student("980001L", "John", "A", "Smith", 3.94f, LocalDate.of(2018, 10, 24),tr1);
       Student s2 = new Student("980002L", "Anna","Marie","Jones", 3.05f, LocalDate.of(2019, 3, 15),tr2);
       
       // save student with transcript
       saveStudents(Arrays.asList(s1,s2));
       
       
       
       Transcript tr3 = new Transcript("BS Mathematics");
       Transcript tr4 = new Transcript("PhD Vedic Science");
       Transcript tr5 = new Transcript("MA Film Production");

       // Create 5 new students
       Student s3 = new Student("980003L", "Peter", "A", "Harrington", 2.90f, LocalDate.of(2018, 10, 24),tr3);
       Student s4 = new Student("980004L", "Ducarmel", "R.", "Saint-Jean", 3.77f, LocalDate.of(2018, 10, 24),tr4);
       Student s5 = new Student("980005L", "Mary", "W.", "Washington", 3.26f, LocalDate.of(2019, 3, 13),tr5);
	   
       // lets assign students in classroom (one to many)
	   ClassRoom classRoom = new ClassRoom("112", "Veril-Hall");
	   s3.setClassRoom(classRoom);
	   s4.setClassRoom(classRoom);
	   s5.setClassRoom(classRoom);
	   List<Student> savedStudents= Arrays.asList(s3,s4,s5);
	   classRoom.setStudents(savedStudents);
	   saveClassRoom(classRoom);
	   
	}
	
	
	public Student saveStudent(Student student)
	{
		return studentService.saveStudent(student);
	}
	
	public List<Student> saveStudents(List<Student> students)
	{
		List<Student> returnedStudents = new ArrayList<Student>();
		for(Student s : students)
		{
			returnedStudents.add(studentService.saveStudent(s));
		}
		return returnedStudents;
	}
	
	public Transcript saveTranscript(Transcript transcript)
	{
		return transcriptService.saveTranscript(transcript);
	}

	
	public Student readStudentbyId(Long id)
	{
		return studentService.readStudentById(id);
	}
	
	public ClassRoom saveClassRoom(ClassRoom classRoom) {
		 return classRoomService.saveClassroom(classRoom);
	}
	
	public void assignStudentsToClassRoom(ClassRoom classRoom, List<Student> students)
	{
		students.forEach(x->x.setClassRoom(classRoom));
		students.forEach(studentService::saveStudent);
	}
	
	public Course saveCourse(Course course)
	{
		return courseService.saveCourse(course);
	}
	
	public void assignStudentsToCourse(Course course, List<Student> students)
	{
		course.setStudents(students);
		students.forEach(x->x.addCourse(course));
	}
	
	public List<Student> readAllStudents()
	{
		return studentService.getAllStudents();
	}

}
