package fp.topic9.print;

import fp.topic9.print.threads.PrintThread;

public class PrintThreadsIsAlive
{
   public static void main(String args[]) throws InterruptedException
   {
      System.out.println("In main before creating threads");

      Thread pT1 = new PrintThread(10000);
      Thread pT2 = new PrintThread(20000);
      pT1.start();
      pT2.start();

      // wait until threads finish
      // this is CPU intensive so not the best way
      // comment this out to see the difference
      while (pT1.isAlive() || pT2.isAlive())
         ;

      // .. should REALLY use join() instead!
      // pT1.join();
      // pT2.join();

      System.out.println("\nThreads have finished");
   }
}
