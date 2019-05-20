package fp.topic3.delegation;

// class C is an A (inherited through AbstractA)and a B
// alternatively we could extend AbstractB, and implement/delegate A
//
// Caspar's imaginary syntax
// public class ConcreteC extends AbstractA delegates interface B to BDelegate 
public class ConcreteC extends AbstractA implements B
{
	// this attribute will implement the "B" functionality via the BDelegate class
	// and avoid us cutting and pasting (since we cannot extend two abstract classes)
	private B b = new BDelegate();

	public ConcreteC()
	{
		// this constructs the "A" portion via superclass AbstractA
		super();
	}

	// method_a() is inherited from superclass AbstractA

	// method_b() from interface B is delegated to attribute "b"
	// which avoids having to duplicate method body here
	@Override
	public String method_b()
	{
		return b.method_b();
	}

	// forward other methods of B interface if it had more than one method
}
