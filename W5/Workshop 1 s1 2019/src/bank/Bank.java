package bank;

import java.util.LinkedHashMap;
import java.util.Map;

import customer.Customer;

public class Bank
{
   private Map<String, Customer> customers = new LinkedHashMap<>();

   public void addCustomer(Customer customer)
   {
      customers.put(customer.getId(), customer);
   }

   public boolean removeCustomer(Customer customer)
   {
      return customers.remove(customer.getId()) != null;
   }

   @Override
   public String toString()
   {
      StringBuilder builder = new StringBuilder();
      for (Customer customer : customers.values())
         builder.append(customer.toString()).append('\n');
      return builder.toString();
   }
}
