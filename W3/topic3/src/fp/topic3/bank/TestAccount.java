package fp.topic3.bank;

import fp.topic3.account.Account;
import fp.topic3.account.CreditAccount;
import fp.topic3.account.SavingsAccount;

public class TestAccount
{
	public static void main(String[] args)
	{
		Account saccount1 = new SavingsAccount("1", 100.0);
		Account saccount2 = new SavingsAccount("2", 100.0);
		Account caccount3 = new CreditAccount("3", 0.0);
		Account caccount4 = new CreditAccount("4", 0.0);

		//BankAccount[] accounts = new BankAccount[] { saccount1, caccount4 };
		
		saccount1.deposit(100.0);
		saccount2.deposit(200.0);
		saccount1.withdraw(50.0);
		saccount2.withdraw(50.0);
		saccount1.transfer(50.0, saccount2);

		caccount3.deposit(100.0);
		caccount4.deposit(200.0);
		caccount3.withdraw(50.0);
		caccount4.withdraw(50.0);
		saccount1.transfer(50.0, caccount4);

		System.out.println(saccount1);
		System.out.println(saccount2);
		System.out.println(caccount3);
		System.out.println(caccount4);
	}
}
