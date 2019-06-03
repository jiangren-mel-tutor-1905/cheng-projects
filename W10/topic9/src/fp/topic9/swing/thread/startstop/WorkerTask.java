package fp.topic9.swing.thread.startstop;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WorkerTask implements Runnable
{
   // use the Java system logger instead of println
   private Logger logger = Logger.getLogger(this.getClass().getName());

   private JTextArea textArea;

   public WorkerTask(JTextArea textArea)
   {
      this.textArea = textArea;
   }

   @Override
   public void run()
   {
      try
      {
         // this thread runs until it is interrupted externally with a call
         // to interrupt()
         while (true)
         {
            Thread thisThread = Thread.currentThread();

            // check to quit if we have called interrupted on this Thread
            if (thisThread != null && thisThread.isInterrupted())
            {
               // do tidy up first if necessary
               logger.log(Level.INFO, String.format("Thread: %s isInterrupted()==%b", thisThread
                  .getName(), thisThread.isInterrupted()));
               return;
            }

            long start = System.nanoTime();
            // simulate complex calculation
            for (long l = 0; l < 1000000; l++)
               ;
            long stop = System.nanoTime();

            // needs to be final to be visible to Runnable inner class below
            final String msg = String.format("Calculation took: %dns (%d ms)", stop - start,
               TimeUnit.NANOSECONDS.toMillis(stop - start));

            // the method as a Runnable that will update the UI
            Runnable uiUpdateRunnable = new Runnable()
            {
               @Override
               public void run()
               {
                  if (textArea != null)
                     textArea.setText(msg);
               }
            };

            // setText() was documented as thread safe in Java 6 but not Java 7+!
            // seems to work but safest to invoke on UI thread as done below
            // textArea.setText(msg);

            // invoke on the original (UI) thread
            SwingUtilities.invokeLater(uiUpdateRunnable);

            start = System.nanoTime();
            Thread.sleep(100);
            stop = System.nanoTime();
            logger.log(Level.INFO, String.format("Thread: %s Slept: %d ms", thisThread.getName(),
               TimeUnit.NANOSECONDS.toMillis(stop - start)));
         }
      }
      // exit if we are interrupted
      catch (InterruptedException ie)
      {
         Thread thisThread = Thread.currentThread();
         // do tidy up first if necessary
         logger.log(Level.INFO, String.format("Thread: %s caught InterruptedException", thisThread
            .getName()));
         return;
      }
   }
}
