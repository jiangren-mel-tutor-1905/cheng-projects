package customer;

public class Person
{
   private String name;
   private String dob;

   public Person(String name, String dob)
   {
      this.name = name;
      this.dob = dob;
   }

   protected String getName()
   {
      return name;
   }

   protected String getDob()
   {
      return dob;
   }

   @Override
   public String toString()
   {
      return String.format("name=%s, dob=%s", name, dob);
   }
}
