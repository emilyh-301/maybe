package com.cisc181.core;
import java.util.UUID;

public class Enrollment 
{
	private UUID SectionID;
	private double grade;
	private UUID StudentID;
	private UUID EnrollmentID;
	
	private Enrollment()
	{
		
	}
	
	public Enrollment(UUID student, UUID section)
	{
		this.SectionID = section;
		this.StudentID = student;
		this.EnrollmentID = UUID.randomUUID();  
	}
	
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	public double getGrade()
	{
		return this.grade;
	}
		
	public UUID getSectionID()
	{
		return this.SectionID;
	}
	
	public UUID getStudentID()
	{
		return this.StudentID;
	}
	
	
	
} 
