package fp.topic9.print;

import fp.topic9.print.threads.PrintThreadYield;

//refactored by Caspar
public class PrintThreadsYield
{
   public static void main(String args[])
   {
      // second param is whether to yield
      Thread pT1 = new PrintThreadYield(10000, true);
      Thread pT2 = new PrintThreadYield(20000, false);
      pT1.start();
      pT2.start();
      System.out.println("exiting main");
   }
}
