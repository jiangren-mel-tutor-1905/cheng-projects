package main;

import account.Account;
import account.CreditAccount;
import account.SavingsAccount;
import bank.Bank;
import customer.Customer;
import exception.BankingException;

public class TestBank
{

   public static void main(String[] args) throws BankingException
   {
      Bank bank = new Bank();

      Customer customer1 = new Customer("1", "cust1", "1/1/1990");
      Customer customer2 = new Customer("2", "cust2", "2/2/1990");

      bank.addCustomer(customer1);
      bank.addCustomer(customer2);

      Account savings1 = new SavingsAccount("1", 1000.0);
      Account savings2 = new SavingsAccount("2", 100.0);
      Account credit1 = new CreditAccount("3", 1000.0, 5000.0);

      savings1.deposit(500);
      savings1.withdraw(750);
      // 750 

      credit1.deposit(500);
      credit1.withdraw(750);
      // 1250

      customer1.addAccount(savings1);
      customer1.addAccount(credit1);
      customer2.addAccount(savings2);

      System.out.println(bank.toString());
   }

}
