package fp.topic2.account;

public class StudentAccount extends SavingsAccount
{
   private double award;

   public StudentAccount(String id, double balance, double award)
   {
      super(id, balance);
	  this.award = award;
   }

   @Override
   public void deposit(double amount)
   {
      balance += amount + this.award;
   }

   @Override
   public String toString()
   {
      return String.format("StudentAccount: %s", super.toString());
   }
}
