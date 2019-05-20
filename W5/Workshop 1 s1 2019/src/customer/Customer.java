package customer;

import java.util.LinkedHashMap;
import java.util.Map;

import account.Account;

public class Customer extends Person
{
   private String id;
   private Map<String, Account> accounts = new LinkedHashMap<>();

   public Customer(String id, String name, String dob)
   {
      super(name, dob);
      this.id = id;
   }

   public void addAccount(Account account)
   {
      accounts.put(account.getId(), account);
   }

   public boolean removeAccount(Account account)
   {
      return accounts.remove(account.getId()) != null;
   }

   public String getId()
   {
      return id;
   }

   @Override
   public String toString()
   {
      StringBuilder builder = new StringBuilder();
      builder.append(String.format("Customer: id=%s, %s\n", id, super.toString()));
      for (Account account : accounts.values())
         builder.append(account.toString()).append('\n');
      return builder.toString();
   }
}
