package edu.mum.cs.cs425.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classroom")
public class ClassRoom {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classRoom")	
	private List<Student> students= new ArrayList<>();
	
	@Column(name="room")
	private String room;
	
	@Column(name = "building")
	private String building;

	public ClassRoom() {
	}
	
	public ClassRoom(List<Student> students, String room, String building) {
		this.students = students;
		this.room = room;
		this.building = building;
	}

    public ClassRoom(String room, String building) {
		this.room = room;
		this.building = building;
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getClassRoom() {
		return room;
	}
	public void setClassRoom(String classRoom) {
		this.room = classRoom;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", students=" + students + ", room=" + room + "]";
	}
	
	

	
}
