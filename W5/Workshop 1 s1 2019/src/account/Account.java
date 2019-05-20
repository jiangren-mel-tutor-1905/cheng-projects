package account;

import exception.BankingException;

public interface Account
{
   public abstract String getId();

   double getBalance();

   void withdraw(double amount) throws BankingException;

   void deposit(double amount);

   boolean transfer(Account fromAccount, double amount);
}
