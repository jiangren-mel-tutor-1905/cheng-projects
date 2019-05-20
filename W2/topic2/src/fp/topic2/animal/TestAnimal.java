package fp.topic2.animal;

class TestAnimal
{
   public static void main(String[] args)
   {
      Animal[] animals = new Animal[] { new Cat(), new Dog(), new Bird() };
      for (Animal animal : animals)
         System.out.println(animal.speak());
   }
}