package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test 
{

	private static ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException 
	{
		Staff Emily = new Staff("Emily", "Virginia", "Haigh", new Date(1998, 7, 24), "916 Willcliff Drive",
				"(717)-713-1478", "emilyh4321@gmail.com", "Monday 2-3", 2, 700000, new Date(2008, 3, 14), eTitle.MS);
		
		Staff Elliot = new Staff("Elliot", "Andrew", "Haigh", new Date(1998, 7, 24), "916 Willcliff Drive",
				"(717)-713-6045", "ellioth4321@gmail.com", "Tuesday 2-3", 3, 300000, new Date(2008, 3, 14), eTitle.MR);
		
		Staff Hugh = new Staff("Hugh", "Fitzpatrick", "Murchie", new Date(1999, 8, 24), "5 Appian Drive",
				"(717)-713-5988", "hugh@gmail.com", "Friday 12 - 1", 2, 600000, new Date(2005, 1, 14), eTitle.MR);
		
		Staff Kate = new Staff("Kate", "Rose", "Minnich", new Date(1999, 4, 28), "16 Stone Run Drive",
				"(717)-713-2090", "kate@gmail.com", "Monday 10 - 11", 1, 50000, new Date(2008, 3, 14), eTitle.MS);
		
		Staff Fox = new Staff("Fox", "Larry", "Mulder", new Date(1967, 2, 4), "13 xfiles Drive",
				"(717)-713-5112", "foxmulder@fbi.com", "Monday 3 - 4", 3, 123450, new Date(1993, 3, 14), eTitle.MR);
		
		staffList.add(Emily);
		staffList.add(Elliot);
		staffList.add(Hugh);
		staffList.add(Kate);
		staffList.add(Fox);
	}
	
	@Test
	public void test() 
	{
		double money = 0.0;
		for(Staff s : staffList)
		{
			money += s.getSalary();
		}
		money /= 5;
		assertEquals(money,354690,.001);
		
		boolean thrown1 = false;
		try
		{
			Staff Nick = new Staff("Nick", "James", "Jonas", new Date(1901, 8, 3), "2 Lilly Lane",
					"(717)-713-0443", "nickjonas@gmail.com", "Friday 12 - 1", 2, 600000, new Date(2015, 1, 27), eTitle.MR);
		}
		catch(PersonException e)
		{
			thrown1 = true;
		}
		assertTrue(thrown1);
		
		boolean thrown2 = false;
		try
		{
			Staff Nick = new Staff("Nick", "James", "Jonas", new Date(1951, 8, 3), "2 Lilly Lane",
					"(717)-713-043", "nickjonas@gmail.com", "Friday 12 - 1", 2, 600000, new Date(2015, 1, 27), eTitle.MR);
		}
		catch(PersonException e)
		{
			thrown2 = true;
		}
		assertTrue(thrown2);	
		
	}	

}
