package fp.topic4.generic;

class Customer2
{
}

class Product
{
}

class Member
{
}

class Share
{
}

public class TestTransactions
{
	public static void main(String args[])
	{
		Transactions<Customer2, Product> sales = new Transactions<Customer2, Product>("Customer Sales");
		Transactions<Member, Share> trades = new Transactions<Member, Share>("Share Trades");
		sales.add(new Customer2(), new Product(), 6);
		sales.add(new Customer2(), new Product(), 18);
		trades.add(new Member(), new Share(), 12);
		trades.add(new Member(), new Share(), 7);
		trades.add(new Member(), new Share(), 5);
		sales.list();
		trades.list();
	}
}
