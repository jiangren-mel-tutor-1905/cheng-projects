package fp.topic9.print;

import fp.topic9.print.threads.PrintThreadPriority;

//refactored by Caspar
public class PrintThreadsPriority
{
   public static void main(String args[]) throws InterruptedException
   {
      System.out.println("In Main Before Thread Creation");
      // second param is priority
      Thread pT1 = new PrintThreadPriority(10000, Thread.MIN_PRIORITY);
      Thread pT2 = new PrintThreadPriority(20000, Thread.MAX_PRIORITY);
      pT1.start();
      pT2.start();

      // Caspar: seems to be fixed at Eclipse 2019-03 and JDK 11?
      // https://stackoverflow.com/questions/2225737/error-jdwp-unable-to-get-jni-1-2-environment
      // wait for threads to finish then System.exit(0)
      //      pT1.join();
      //      pT2.join();
      System.out.println("In Main After Threads Finished");
      //System.exit(0);
   }
}
