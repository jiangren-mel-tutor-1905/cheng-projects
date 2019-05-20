package fp.topic2.account;

public class SavingsAccount extends BankAccount
{
   public SavingsAccount(String id, double balance)
   {
      super(id, balance);
   }

   @Override
   public boolean withdraw(double amount)
   {
      if (balance >= amount)
      {
         balance -= amount;
         return true;
      }
      return false;
   }

   @Override
   public void deposit(double amount)
   {
      balance += amount;
   }

   @Override
   public String toString()
   {
      return String.format("Savings: %s", super.toString());
   }
}
