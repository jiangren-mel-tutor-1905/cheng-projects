package fp.topic9.print;

import fp.topic9.print.threads.PrintThread;
import fp.topic9.print.threads.PrintThreadSleep;

public class PrintThreadsSleep
{
   public static void main(String args[])
   {
      Thread pT1 = new PrintThreadSleep(10000, 10050);
      Thread pT2 = new PrintThread(20000);
      pT1.start();
      pT2.start();
   }
}
