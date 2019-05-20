package fp.topic3.delegation;

//simple abstract class with one attribute and method that implements interface B 
public abstract class AbstractB implements B
{
	// an example private attribute
	private String attribute;

	// a simple default constructor
	public AbstractB()
	{
		attribute = "Abstract B";
	}

	// ... getter/setters etc. ignored

	// default implementation of B interface
	@Override
	public String method_b()
	{
		return attribute;
	}
}
