package fp.topic1.bank;

public class Person
{
	private String name;
	private String dob;
	private String customerID;

	public Person(String name, String dob, String customerID)
	{
		this.name = name;
		this.dob = dob;
		this.customerID = customerID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		this.dob = dob;
	}

	public String getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}
}
