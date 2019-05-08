package fp.topic1.bank.account;

import fp.topic1.bank.exception.BankingException;

public abstract class AbstractAccount implements Account
{
   private String id;
   private Double balance;

   public AbstractAccount(String id, Double balance)
   {
      this.id = id;
      this.balance = balance;
   }

   public String getId()
   {
      return id;
   }

   public Double getBalance()
   {
      return balance;
   }

   protected void setBalance(Double balance)
   {
      this.balance = balance;
   }

   @Override
   public boolean transfer(double amount, Account account)
   {
      try
      {
         this.withdraw(amount);
         account.deposit(amount);
         return true;
      }
      catch (BankingException e)
      {
         return false;
      }
   }

   @Override
   public String toString()
   {
      return String.format("Account id: %s, balance=%.2f", getId(), getBalance());
   }
}
