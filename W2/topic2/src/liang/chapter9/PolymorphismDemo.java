package liang.chapter9;

public class PolymorphismDemo
{
   public static void main(String[] args)
   {
      m(new GraduateStudent());
      m(new Student());
      m(new Person2());

      // added by Caspar for more realistic polymorphism demo
      Person2[] people = new Person2[3];
      people[0] = new GraduateStudent();
      people[1] = new Student();
      people[2] = new Person2();

      System.out.println("And now through a loop");
      for (int i = 0; i < people.length; i++)
         System.out.println(people[i].toString());
   }

   public static void m(Person2 x)
   {
      System.out.println(x.toString());
   }
}

class GraduateStudent extends Student
{
   public String toString()
   {
      return "Grad Student";
   }
}

class Student extends Person2
{
   public String toString()
   {
      return super.toString() + " Student";
   }
}

class Person2
{
   public String toString()
   {
      return "Person";
   }
}
