package fp.topic4.generic;

/* Adapted from Supplement Q: Generic Types By Y. Daniel Liang */
// Note: see java.util.Stack for more generic implementation
class GenericStack<T>
{
	private T[] elements;
	private int size;

	// constructs a stack with the default capacity 10 
	public GenericStack()
	{
		this(10);
	}

	// constructs a stack with the specified initial capacity 
	@SuppressWarnings("unchecked")
	public GenericStack(int capacity)
	{
		elements = (T[]) new Object[capacity];
	}

	// puts the new element into the top of stack 
	public T push(T value)
	{
		if (size >= elements.length)
			setCapacity(elements.length * 2);
		return elements[size++] = value;
	}

	// returns and removes the top element from the stack 
	public T pop()
	{
		return elements[--size];
	}

	// returns top element without removing 
	public T peek()
	{
		return elements[size - 1];
	}

	// tests whether the stack is empty  
	public boolean empty()
	{
		return size == 0;
	}

	// returns the number of elements in the stack  
	public int getSize()
	{
		return size;
	}

	// returns the capacity 
	public int getCapacity()
	{
		return elements.length;
	}

	// sets new capacity - must be greater than current capacity
	@SuppressWarnings("unchecked")
	public boolean setCapacity(int newCapacity)
	{
		if (newCapacity > elements.length)
		{
			T[] temp = (T[]) new Object[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
			return true;
		}
		else
			return false;
	}
}
