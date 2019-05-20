package fp.topic2.animal;

public class Animal
{
   public String speak()
   {
      throw new UnsupportedOperationException("must override speak");
   }
}

class Dog extends Animal
{
   @Override
   public String speak()
   {
      return "Dog says bark";
   }
}

class Cat extends Animal
{
   @Override
   public String speak()
   {
      return "Cat says meow";
   }
}

class Bird extends Animal
{
   //   @Override
   //   public String speak()
   //   {
   //      return "Bird says chirp then tweet";
   //   }
}
