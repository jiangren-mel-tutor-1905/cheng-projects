package fp.topic2.account;

public interface BankAccountBase
{

	public boolean withdraw(double amount);

	public void deposit(double amount);

	public boolean transfer(BankAccountBase dest, double amount);

	public String getId();

	public double getBalance();
}
