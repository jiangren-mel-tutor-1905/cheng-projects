package fp.topic4.generic;

public class TestGenericStack
{
	public static void main(String args[])
	{
		GenericStack<String> stack1 = new GenericStack<String>();
		stack1.push("Perth");
		stack1.push("Melbourne");
		stack1.push("Sydney");
		System.out.println("stack1.pop() = " + stack1.pop());

		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		stack2.push(10);
		stack2.push(20);
		stack2.push(30);
		System.out.println("stack2.pop() = " + stack2.pop());
		for (int i = 0; i < 25; i++)
			stack2.push(i);
		System.out.println("Num. of elements in stack2 " + stack2.getSize());
		System.out.println("Current capacity of stack2 " + stack2.getCapacity());
	}
}
