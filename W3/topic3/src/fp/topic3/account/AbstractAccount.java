package fp.topic3.account;

// superclass
public abstract class AbstractAccount implements Account
{
   protected String id;
   protected double balance;

   public AbstractAccount(String id, double balance)
   {
      this.id = id;
      this.balance = balance;
   }

   @Override
   public String getId()
   {
      return id;
   }

   @Override
   public double getBalance()
   {
      return balance;
   }

   @Override
   public boolean transfer(double amount, Account account)
   {
      if (this.withdraw(amount))
      {
         account.deposit(amount);
         return true;
      }
      return false;
   }

   @Override
   public String toString()
   {
      return String.format("Id: %s, Balance: %.02f", getId(), getBalance());
   }
}
