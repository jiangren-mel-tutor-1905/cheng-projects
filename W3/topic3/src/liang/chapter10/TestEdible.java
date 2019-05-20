package liang.chapter10;

public class TestEdible
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Animal[] animals =
		{ new Tiger(), new Chicken() };
		Edible[] edibles =
		{ new Chicken(), new Apple() };
		int cal = Edible.CALORIES;
		for (int i = 0; i < edibles.length; i++)
			showObject(edibles[i]);
	}

	public static void showObject(Edible object)
	{
		// Caspar: no longer required
		// if (object instanceof Edible)
		System.out.println(object.howToEat());
	}
}

// Caspar: is this class required?
abstract class Fruit implements Edible
{
	@Override
	public String howToEat()
	{
		return "Eat it fresh";
	}
}

class Apple extends Fruit
{
	@Override
	public String howToEat()
	{
		return "Make apple cider";
	}
}

class Orange extends Fruit
{
	@Override
	public String howToEat()
	{
		return "Make orange juice";
	}
}

abstract class Animal
{
	static final int DEFAULT_WEIGHT = 5;
}

@SuppressWarnings("rawtypes")
// Caspar: could some if this go in the abstract superclass?
class Chicken extends Animal implements Edible, Comparable
{
	int weight;

	public Chicken()
	{
		weight = DEFAULT_WEIGHT;
	}

	public Chicken(int weight)
	{
		this.weight = weight;
	}

	@Override
	public String howToEat()
	{
		return "Fry it";
	}

	@Override
	public int compareTo(Object o)
	{
		return weight - ((Chicken) o).weight;
	}
}

class Tiger extends Animal
{
}
