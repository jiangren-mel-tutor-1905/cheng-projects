package fp.topic3.delegation;

// simple abstract class with one attribute and method that implements interface A
public abstract class AbstractA implements A
{
	// an example private attribute
	private String attribute;

	// a simple default constructor
	public AbstractA()
	{
		attribute = "Abstract A";
	}

	// ... getter/setters etc. ignored

	// default implementation of A interface
	@Override
	public String method_a()
	{
		return attribute;
	}
}
