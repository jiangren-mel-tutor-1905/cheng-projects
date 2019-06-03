package fp.topic9.print.threads;

//refactored by Caspar
public abstract class AbstractPrintThread extends Thread
{
   protected int initial;

   public AbstractPrintThread(int val)
   {
      super();
      initial = val;
   }

   @Override
   public void run() // overriding the run method
   {
      for (int i = initial; i <= initial + 100; i++)
      {
         // note periodic line break .. but all threads write to same console so doesn't work that well :P
         System.out.printf("%d %s", i, ((i % 9) == 0) ? "\n" : "");

         // this is a utility (template) method we can override
         doSomething(i);
      }
   }

   // template method is another GoF (Gamma et al.) Design Pattern!
   protected abstract void doSomething(int i);
}