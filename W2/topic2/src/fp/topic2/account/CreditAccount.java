package fp.topic2.account;

public class CreditAccount extends BankAccount
{
   private double creditLimit = 10000.0;

   public CreditAccount(String id, double balance)
   {
      super(id, balance);
   }

   @Override
   public boolean withdraw(double amount)
   {
      if (balance + amount <= creditLimit)
      {
         balance += amount;
         return true;
      }
      return false;
   }

   @Override
   public void deposit(double amount)
   {
      balance -= amount;
   }

   @Override
   public String toString()
   {
      return String.format("Credit: %s, limit=%s", super.toString(), creditLimit);
   }
}
