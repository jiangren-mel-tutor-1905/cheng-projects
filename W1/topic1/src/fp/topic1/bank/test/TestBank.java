package fp.topic1.bank.test;

import fp.topic1.bank.Bank;
import fp.topic1.bank.Customer;
import fp.topic1.bank.account.Account;
import fp.topic1.bank.account.CreditAccount;
import fp.topic1.bank.account.SavingsAccount;
import fp.topic1.bank.exception.BankingException;
import fp.topic1.bank.exception.InsufficientCreditException;
import fp.topic1.bank.exception.InsufficientFundsException;

public class TestBank
{
	public TestBank()
	{
		Bank bank = new Bank();
		Customer customer1 = new Customer("joe", "1/1/2000", "customer1");
		Customer customer2 = new Customer("jill", "1/1/1998", "customer2");
		bank.addCustomer(customer1);
		bank.addCustomer(customer2);

		Account savings = new SavingsAccount("1", 0.0);
		Account credit = new CreditAccount("2", 0.0);

		customer1.addAccount(savings);
		customer1.addAccount(credit);

		try
		{
			savings.deposit(1000.0);
			savings.withdraw(500.0);
			credit.withdraw(1000.0);
			credit.deposit(500.0);
		}
		catch (InsufficientFundsException ef)
		{
			System.out.println("insufficient funds");
		}
		catch (InsufficientCreditException ec)
		{
			System.out.println("insufficient credit");
		}
		catch (BankingException ex)
		{
			// should not be reachable with current classes
			System.out.println("banking exception");
		}

		customer1.listAccounts();
		customer2.listAccounts();
	}

	public static void main(String[] args)
	{
		new TestBank();
	}
}
