package com.springsecurity.springsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="STUDENT")
@Data
public class Student {


	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	    private String name;
	    private int marks;


	    public Student(int id, String name,int marks) {
	        this.id = id;
	        this.name = name;
	        this.marks = marks;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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
	        return "StudentController{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", marks=" + marks +
	                '}';
	    }
}
