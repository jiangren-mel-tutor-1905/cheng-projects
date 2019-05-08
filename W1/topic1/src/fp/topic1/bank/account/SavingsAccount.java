package fp.topic1.bank.account;

import fp.topic1.bank.exception.BankingException;
import fp.topic1.bank.exception.InsufficientFundsException;

public class SavingsAccount extends AbstractAccount
{
	public SavingsAccount(String id, Double balance)
	{
		super(id, balance);
	}

	@Override
	public void withdraw(Double amount) throws BankingException
	{
		if (getBalance() - amount >= 0)
			setBalance(getBalance() - amount);
		else
			throw new InsufficientFundsException();
	}

	@Override
	public void deposit(Double amount)
	{
		setBalance(getBalance() + amount);
	}

	@Override
	public void applyFees()
	{
	}

	@Override
	public void applyInterest()
	{
	}

	public String toString()
	{
		return String.format("Savings: %s", super.toString());
	}
}
