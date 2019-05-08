package fp.topic1.bank;

import java.util.HashSet;
import java.util.Set;

public class Bank
{
	// set of customers
	private Set<Customer> customerSet = new HashSet<Customer>();

	public void addCustomer(Customer customer)
	{
		customerSet.add(customer);
	}

	public void removeAccount(Customer customer)
	{
		customerSet.remove(customer);
	}
}
