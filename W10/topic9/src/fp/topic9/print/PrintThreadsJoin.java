package fp.topic9.print;

import fp.topic9.print.threads.PrintThread;
import fp.topic9.print.threads.PrintThreadJoin;

public class PrintThreadsJoin
{
   public static void main(String args[])
   {
      Thread pT1 = new PrintThread(10000);
      Thread pT2 = new PrintThreadJoin(20000, pT1);
      // start 2 first to help ensure we get to join()
      pT2.start();
      pT1.start();
   }
}
