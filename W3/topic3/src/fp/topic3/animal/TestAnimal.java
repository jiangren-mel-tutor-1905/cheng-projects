package fp.topic3.animal;

class TestAnimal
{
	public static void main(String[] args)
	{
		Cat[] cats = new Cat[]
		{ new Cat(), new Cat(), new Cat() };
		Animal[] animals = new Animal[]
		{ cats[0], cats[1], cats[2], new Dog(), new Bird() };
		for (Animal animal : animals)
			System.out.println(animal.speak());
		for (Cat cat : cats)
			cat.purr();
	}
}