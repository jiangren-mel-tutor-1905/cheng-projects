package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThread extends AbstractPrintThread
{
   public PrintThread(int val)
   {
      super(val);
   }

   // default is to do nothing extra
   @Override
   protected void doSomething(int i)
   {
      // threads interlace more if we extend the running time
      //      for (long l = 0; l < 10000000; l++)
      //         ;
   }
}