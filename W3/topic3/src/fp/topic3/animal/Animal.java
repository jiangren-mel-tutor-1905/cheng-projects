package fp.topic3.animal;

public interface Animal
{
	public abstract String speak();
}

interface Animal2 extends Animal
{
	public void newMethod();
}

class Dog implements Animal
{
	@Override
	public String speak()
	{
		return "Dog says bark";
	}
}

class Cat implements Animal
{
	@Override
	public String speak()
	{
		return "Cat says meow";
	}

	public void purr()
	{
		System.out.println("purr");
	}
}

class Bird implements Animal
{
	@Override
	public String speak()
	{
		return "Bird says chirp then tweet";
	}
}
