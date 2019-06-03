package fp.topic9.print;

import fp.topic9.print.threads.PrintThread;

//refactored by Caspar
public class PrintThreads
{
   public static void main(String args[]) throws Exception
   {
      System.out.println("In Main Before Thread Creation");
      Thread pT1 = new PrintThread(10000); // First Thread instance
      Thread pT2 = new PrintThread(20000); // Second Thread instance

      // Daemon threads do not keep VM alive
      //      pT1.setDaemon(true);
      //      pT2.setDaemon(true);

      pT1.start(); // First Thread started
      pT2.start(); // Second Thread started

      // PrintThread pT3 = new PrintThread(50000);
      // pT3.start();
      System.out.println("In main After Thread Creation");
   }
}
