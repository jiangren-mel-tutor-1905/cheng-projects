package fp.topic4.notgeneric;

public class Account
{
	private String accountNum;

	private String name;

	private double amount;

	public String getName()
	{
		return name;
	}

	public Account(String accountNum, String name, double amount)
	{
		this.accountNum = accountNum;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return String.format("(accountNum=%s, name=%s, amount=%s)", accountNum, name, amount);
	}
}