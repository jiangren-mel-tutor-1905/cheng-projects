package fp.topic3.account;

public interface Account
{
	public abstract String getId();

	public abstract double getBalance();

	public abstract void deposit(double amount);

	public abstract boolean withdraw(double amount);

	public abstract boolean transfer(double amount, Account account);
}