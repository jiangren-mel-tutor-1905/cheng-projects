package fp.topic4.generic;

public class Account
{
   private String accountNum;

   private String name;

   private double amount;

   public String getName()
   {
      return name;
   }

   public Account()
   {
      accountNum = Double.valueOf(Math.random()).toString();
      name = "caspar";
      amount = 0.0;
   }

   public Account(String accountNum, String name, double amount)
   {
      this.accountNum = accountNum;
      this.name = name;
      this.amount = amount;
   }

   public String toString()
   {
      return accountNum + ":" + name + ":" + amount;
   }
}