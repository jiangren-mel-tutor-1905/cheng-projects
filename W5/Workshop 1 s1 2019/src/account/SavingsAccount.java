package account;

import exception.BankingException;
import exception.InsufficientFundsException;

public class SavingsAccount extends AbstractAccount
{
   public SavingsAccount(String id, double balance)
   {
      super(id, balance);
   }

   @Override
   public void withdraw(double amount) throws BankingException
   {
      if (getBalance() - amount >= 0)
         setBalance(getBalance() - amount);
      else
         throw new InsufficientFundsException();
   }

   @Override
   public void deposit(double amount)
   {
      setBalance(getBalance() + amount);
   }

   @Override
   public String toString()
   {
      return "Savings" + super.toString();
   }
}
