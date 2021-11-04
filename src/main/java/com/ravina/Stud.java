package com.ravina;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Stud_Table")
public class Stud {
	@Id
	
	int rollno;
	@Column(name="Stud_names")
	String name;
	//@Transient
	int marks;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Stud [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}
