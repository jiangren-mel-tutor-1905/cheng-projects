package fp.topic1.bank.account;

import fp.topic1.bank.exception.BankingException;
import fp.topic1.bank.exception.InsufficientCreditException;

public class CreditAccount extends AbstractAccount
{
	private static final Double CREDIT_LIMIT = 5000.0;

	public CreditAccount(String id, Double balance)
	{
		super(id, balance);
	}

	@Override
	public void withdraw(Double amount) throws BankingException
	{
		if (getBalance() + amount <= CREDIT_LIMIT)
			setBalance(getBalance() + amount);
		else
			throw new InsufficientCreditException();
	}

	@Override
	public void deposit(Double amount)
	{
		setBalance(getBalance() - amount);
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
		return String.format("Credit: %s", super.toString());
	}
}
