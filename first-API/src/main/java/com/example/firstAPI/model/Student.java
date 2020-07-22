package com.example.demo.model;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String regNo;
	private Date regDate;
	
	public Student() {
		
		
	}
	
	
	public Student(String fname,String lname,String regNo,String regDate) {
		
		firstName=fname;
		lastName=lname;
		this.regNo=regNo;
    this.regDate=regDate;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

    
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="firstName",nullable=false)
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LastName",nullable=false)
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="RegNo",nullable=false) 
	public String getRegNo() {
		return regNo;
	}

	
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
	@Column(name="RegDate",nullable=false)
	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", regNo=" + regNo
				+ ", regDate=" + regDate + "]";
	}


	
}
