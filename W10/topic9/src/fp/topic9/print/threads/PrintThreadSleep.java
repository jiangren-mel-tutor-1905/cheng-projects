package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThreadSleep extends AbstractPrintThread
{
   private int sleepAtNum;

   public PrintThreadSleep(int val, int sleepAtNum)
   {
      super(val);
      this.sleepAtNum = sleepAtNum;
   }

   @Override
   protected void doSomething(int i)
   {
      final long SLEEP_MS = 100;

      // this method is called by the superclass (it is a template method)
      try
      {
         if (i == sleepAtNum)
            Thread.sleep(SLEEP_MS);
      }
      catch (InterruptedException ex)
      {
      }
   }
}