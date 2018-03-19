package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.*;

public class Student_Test 
{
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static ArrayList<Semester> semesters = new ArrayList<Semester>();
	private static ArrayList<Section> sections = new ArrayList<Section>();
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrolls = new ArrayList<Enrollment>();
	private static double[] studentsGrades = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	private static ArrayList<UUID> studentsUUIDs = new ArrayList<UUID>();
	private static double[] sectionGrades = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	private static ArrayList<UUID> sectionUUIDs = new ArrayList<UUID>();
	
	@BeforeClass
	public static void setup() throws PersonException 
	{
		final UUID ciscUUID = UUID.randomUUID();
		final UUID chemUUID = UUID.randomUUID();
		final UUID mathUUID = UUID.randomUUID();
		Course c1 = new Course(ciscUUID, "CISC181", 4, eMajor.COMPSI);
		Course c2 = new Course(chemUUID, "CHEM101", 3, eMajor.CHEM);
		Course c3 = new Course(mathUUID, "MATH114", 3, eMajor.BUSINESS);
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		final UUID fallUUID = UUID.randomUUID();
		final UUID springUUID = UUID.randomUUID();
		Semester fall = new Semester(fallUUID, new Date(2017, 8, 29), new Date(2017, 12, 16));
		Semester spring = new Semester(springUUID, new Date(2018, 2, 5), new Date(2018, 5, 24));
		semesters.add(new Semester());
		semesters.add(new Semester());
				
		int r = 100;
		for(Semester x : semesters)
		{
			for(Course y : courses)
			{
				sections.add(new Section(y.getCourseID(), x.getSemesterID(), UUID.randomUUID(), r));
				r += 13;
			}
		}
						
		Student Emily = new Student("Emily", "Virginia", "Haigh", new Date(1998, 7, 24), eMajor.COMPSI,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Elliot = new Student("Elliot", "Andrew", "Haigh", new Date(1998, 7, 24), eMajor.BUSINESS,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Hugh = new Student("Hugh", "Fitzpatrick", "Murchie", new Date(1999, 8, 24), eMajor.COMPSI,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Kate = new Student("Kate", "Rose", "Minnich", new Date(1997, 5, 6), eMajor.NURSING,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Amy = new Student("Amy", "Bob", "Mackinnon", new Date(1992, 12, 23), eMajor.PHYSICS,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Justin = new Student("Justin", "James", "Drew", new Date(1990, 1, 15), eMajor.PHYSICS,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Kathleen = new Student("Kathleen", "Marie", "Haigh", new Date(1965, 2, 18), eMajor.BUSINESS,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Sara = new Student("Sara", "Elizabeth", "Bixler", new Date(1943, 4, 21), eMajor.CHEM,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Jared = new Student("Jared", "Thomas", "Weaver", new Date(2000, 6, 9), eMajor.COMPSI,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		Student Travis = new Student("Travis", "John", "Zhering", new Date(1973, 9, 11), eMajor.COMPSI,
				"916 Willcliff Drive", "(717)-713-1478", "evhaigh@udel.edu");
		
		students.add(Emily);
		students.add(Elliot);
		students.add(Hugh);
		students.add(Kate);
		students.add(Amy);
		students.add(Justin);
		students.add(Kathleen);
		students.add(Sara);
		students.add(Jared);
		students.add(Travis);
				
		for(Student s : students)
		{
			studentsUUIDs.add(s.getStudentID());
			for(Section se : sections)
			{
				Enrollment e = new Enrollment(se.getSectionID(), s.getStudentID());
				e.setGrade(85.0);
				enrolls.add(e);
				sectionUUIDs.add(se.getSectionID());
			}
		}
		
		// sets both grade arrays to grades per student and grades per section
		for(Enrollment e : enrolls)
		{
			for(UUID sid : studentsUUIDs)
			{
				if(e.getStudentID().equals(sid))
					studentsGrades[studentsUUIDs.indexOf(sid)] += e.getGrade();
			}
			for(UUID seid : sectionUUIDs)
			{
				if(e.getSectionID().equals(seid))
					sectionGrades[sectionUUIDs.indexOf(seid)] += e.getGrade();
			}
		}
	}

	@Test
	public void test() 
	{
		double[] studentGradeAverage = new double[10];
		double[] sectionGradeAverage = new double[6];
		
		for(int x = 0; x < studentGradeAverage.length; x++)
		{
			studentGradeAverage[x] = studentsGrades[x]/6;
		}
		
		for(int x = 0; x < sectionGradeAverage.length; x++)
		{
			sectionGradeAverage[x] = sectionGrades[x]/10;
		}	
		
		double[] correctSectionAverage = {85.0,85.0,85.0,85.0,85.0,85.0};
		double[] correctStudentAverage = {85.0,85.0,85.0,85.0,85.0,85.0,85.0,85.0,85.0,85.0};
		
		for(int x = 0; x < studentGradeAverage.length; x++)
		{
			if(studentGradeAverage[x] != correctStudentAverage[x])
				assertTrue(false);
		}
		assertTrue(true);
		
		for(int x = 0; x < sectionGradeAverage.length; x++)
		{
			if(sectionGradeAverage[x] != correctSectionAverage[x])
				assertTrue(false);
		}
		assertTrue(true);
	}
}









