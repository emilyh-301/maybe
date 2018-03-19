package com.cisc181.core;
import java.util.Date;
import java.util.UUID;

public class PersonException extends Exception
{
	private Person person; 
	
	public PersonException(Person p) 
	{
		this.person = p;
	}
		
}

