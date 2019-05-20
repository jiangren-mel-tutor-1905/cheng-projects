package liang.chapter9;

public class Faculty extends Employee
{
	private String department;

	public static void main(String[] args)
	{
		new Faculty();
	}

	public String getDepartment()
	{
		return department;
	}

	public Faculty()
	{
		super(); // explicitly call default no-arg constructor
		// super("test");
		System.out.println("(4) Faculty's no-arg constructor is invoked");
	}

	// TODO: add four argument constructor that calls 3 arg super() constructor
}

@SuppressWarnings("unused")
class Employee extends Person
{
	private String employeeNumber;

	public Employee()
	{
		this("(2) Invoke Employee’s overloaded constructor");
		System.out.println("(3) Employee's no-arg constructor is invoked");
	}

	public Employee(String s)
	{
		System.out.println(s);
	}

	public Employee(String name, String dob, String employeeNumber)
	{
		// partial construction from super()
		super(name, dob);
		// setName("");
		this.employeeNumber = employeeNumber;
	}

}

@SuppressWarnings("unused")
class Person
{
	private String name;

	private String dob;

	private void setName(String name)
	{
		this.name = name;
	}

	protected void setDob(String dob)
	{
		this.dob = dob;
	}

	public Person(String name, String dob)
	{
		setName(name);
		setDob(dob);
	}

	public Person()
	{
		System.out.println("(1) Person's no-arg constructor is invoked");
	}
}
