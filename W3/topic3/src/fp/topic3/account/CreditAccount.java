package fp.topic3.account;

public class CreditAccount extends AbstractAccount
{
	private double creditLimit=1000.0;

	// constructors not inherited so have to call the super constructor
	public CreditAccount(String id, double balance)
	{
		super(id, balance);
	}

	@Override
	public void deposit(double amount)
	{
		balance -= amount;
	}

	@Override
	public boolean withdraw(double amount)
	{
		if (balance + amount <= creditLimit)
		{
			balance += amount;
			return true;
		}
		return false;
	}

}
