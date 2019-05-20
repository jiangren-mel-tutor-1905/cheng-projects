package fp.topic3.account;

// subclass because extends BankAccount
public class SavingsAccount extends AbstractAccount
{
	// constructors not inherited so have to call the super constructor
	public SavingsAccount(String id, double balance)
	{
		super(id, balance);
	}

	@Override
	public void deposit(double amount)
	{
		balance += amount;
	}

	@Override
	public boolean withdraw(double amount)
	{
		if (balance >= amount)
		{
			balance -= amount;
			return true;
		}
		return false;
	}
}
