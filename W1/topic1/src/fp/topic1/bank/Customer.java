package fp.topic1.bank;

import java.util.HashMap;
import java.util.Map;

import fp.topic1.bank.account.Account;

public class Customer extends Person
{
	// map id to account
	private Map<String, Account> accountMap = new HashMap<String, Account>();

	public Customer(String name, String dob, String customerID)
	{
		super(name, dob, customerID);
	}

	public void addAccount(Account account)
	{
		accountMap.put(account.getId(), account);
	}

	public void removeAccount(Account account)
	{
		accountMap.remove(account.getId());
	}

	public void listAccounts()
	{
		for (Account account : accountMap.values())
			System.out.println(account.toString());
	}
}
