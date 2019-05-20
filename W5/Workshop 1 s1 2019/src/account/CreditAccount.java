package account;

import exception.BankingException;
import exception.InsufficientCreditException;

public class CreditAccount extends AbstractAccount
{
   private double creditLimit;

   public CreditAccount(String id, double balance, double creditLimit)
   {
      super(id, balance);
      this.creditLimit = creditLimit;
   }

   @Override
   public void withdraw(double amount) throws BankingException
   {
      if (getBalance() + amount <= creditLimit)
         setBalance(getBalance() + amount);
      else
         throw new InsufficientCreditException();
   }

   @Override
   public void deposit(double amount)
   {
      setBalance(getBalance() - amount);
   }

   @Override
   public String toString()
   {
      return String.format("Credit%s, creditLimit=%.2f", super.toString(), creditLimit);
   }
}
