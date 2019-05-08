package sadi.tutelab00.part2;

public class Student
{	
	private String id;
	private String name;
	
	public Student(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return String.format("StudentID: %s, Student Name: %s", id, name);
	}
}
