package fp.topic2.account;

public abstract class BankAccount implements BankAccountBase
{
	protected String id;
	protected double balance;

	public BankAccount(String id, double balance)
	{
		this.id = id;
		this.balance = balance;
	}

	public void deposit(double amount)
	{
	}

	@Override
	public boolean transfer(BankAccountBase dest, double amount)
	{
		if (withdraw(amount))
		{
			dest.deposit(amount);
			return true;
		}

		return false;
	}

	public String getId()
	{
		return id;
	}

	@Override
	public double getBalance()
	{
		return balance;
	}
	
	public boolean equals(BankAccount o) {
		return this.id == o.id && this.balance == o.balance;
	}

	//	@Override
	public String toString()
	{
		return String.format("id=%s, balance=%s", id, balance);
	}
}
