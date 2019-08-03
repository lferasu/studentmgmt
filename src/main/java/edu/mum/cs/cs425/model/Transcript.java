package edu.mum.cs.cs425.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "transcript")
public class Transcript {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "degreetitle")
	private String degreeTitile;
	
	@OneToOne(mappedBy = "transcript", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Student student;
		

	public Transcript()
	{
		
	}

	public Transcript(String degreeTitile) {
		this.degreeTitile = degreeTitile;
	}

	public String getDegreeTitile() {
		return degreeTitile;
	}

	public void setDegreeTitile(String degreeTitile) {
		this.degreeTitile = degreeTitile;
	}

	public long getId() {
		return id;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Transcript [id=" + id + ", degreeTitile=" + degreeTitile + "]";
	}
	
	
}