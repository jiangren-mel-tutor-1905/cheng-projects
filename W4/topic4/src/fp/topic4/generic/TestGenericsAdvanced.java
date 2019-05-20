package fp.topic4.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// advanced generics example by Caspar
class LifeForm
{
	public void live()
	{

	}
}

class Animal extends LifeForm
{
	public void grow()
	{

	}
}

class Dog extends Animal
{
	public void bark()
	{

	}
}

public class TestGenericsAdvanced
{
//	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		List<LifeForm> lifeforms = new ArrayList<LifeForm>();
		List<Animal> animals = new ArrayList<Animal>();
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());

		// this could work in theory since all Dogs are Animals
		// but generics are not polymorphic/covariant in this way
		// animals=dogs;

		// but this is ok since Dog matches the wildcard
		List<? extends Animal> dogAnimals = dogs;
		for (Iterator<? extends Animal> animalIterator = dogAnimals.iterator(); animalIterator.hasNext();)
		{
			// can call Animal methods or above (but not Dog)
			animalIterator.next().grow();
		}

		// do it with a for each
		for (Animal animal : dogAnimals)
		{
			// can call Animal methods or above (but not Dog)
			animal.grow();
		}

		// or we can match up the hierarchy
		List<? super Dog> dogAnimals2 = dogs;

		for (Iterator<? super Dog> animalIterator = dogAnimals2.iterator(); animalIterator.hasNext();)
		{
			// can't do much since <? super Dog> could go all the way to Object
			animalIterator.next().toString();
		}
	}
}
