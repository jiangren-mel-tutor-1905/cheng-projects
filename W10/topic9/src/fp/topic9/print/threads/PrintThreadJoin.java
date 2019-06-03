package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThreadJoin extends AbstractPrintThread
{
   private Thread otherThread;

   public PrintThreadJoin(int val, Thread otherThread)
   {
      super(val);
      this.otherThread = otherThread;
   }

   @Override
   protected void doSomething(int i)
   {
      final int JOIN_AT = 50;
      // this method is called by the superclass (it is a template method)
      // after 50 iterations stop and wait for the other thread to finish
      try
      {
         if (i == initial + JOIN_AT)
            otherThread.join();
      }
      catch (InterruptedException ex)
      {
      }
   }
}