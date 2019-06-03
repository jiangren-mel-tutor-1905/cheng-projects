package fp.topic9.print.threads;

// refactored by Caspar
public class PrintThreadYield extends PrintThread
{
   private boolean yield;

   public PrintThreadYield(int val, boolean yield)
   {
      super(val);
      this.yield = yield;
   }

   @Override
   protected void doSomething(int i)
   {
      // might not do as much on unloaded multicore system unless we set
      // processor affinity for javaw.exe
      // to use one core (via task manager in Windows)
      // the more we call yield() the bigger difference we see
      if (yield)
         //         for (int j = 0; j < 10; j++)
         yield();
      // load up the cpu a bit!
      for (long l = 0; l < 10000000; l++)
         ;
   }
}