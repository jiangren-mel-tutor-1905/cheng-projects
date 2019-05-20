package account;

import java.util.Objects;

import exception.BankingException;

public abstract class AbstractAccount implements Account
{
   private String id;
   private double balance;

   public AbstractAccount(String id, double balance)
   {
      this.id = Objects.requireNonNull(id);
      this.balance = balance;
   }

   @Override
   public boolean transfer(Account fromAccount, double amount)
   {
      try
      {
         fromAccount.withdraw(amount);
         return false;
      }
      catch (BankingException e)
      {
      }
      deposit(amount);
      return true;
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

   protected void setBalance(double balance)
   {
      this.balance = balance;
   }

   @Override
   public int hashCode()
   {
      return id.hashCode();
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof Account))
         return false;
      Account other = (Account) obj;
      if (id == null)
      {
         if (other.getId() != null)
            return false;
      }
      else if (!id.equals(other.getId()))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return String.format("Account: id=%s, balance=%.2f", id, balance);
   }
}
