// Threading example using java.util.concurrent by Caspar Ryan
// Not using MVC, could benefit from refactoring into separate classes!
package fp.topic9.thread.pool;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ThreadTestAppPooled extends JFrame
{
   private static final int MAX_POOL_SIZE = 3;

   // maintain a queue of Future<Boolean> objects from running threads so we
   // can stop them
   // LinkedBlockingQueue is thread safe (standard LinkedList is not)
   private Queue<Future<Boolean>> threadQueue = new LinkedBlockingQueue<Future<Boolean>>();

   // this is our thread pool that manages thread creation
   private ExecutorService executor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
   //private ExecutorService executor = Executors.newCachedThreadPool();

   private JTextArea textArea = new JTextArea(1, 20);

   // the Callable task that will be submitted to the pool
   private WorkerTask workerTask = new WorkerTask(textArea);

   // use the Java system logger instead of println
   private Logger logger = Logger.getLogger(this.getClass().getName());

   private class StartThreadListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // check if thread at head of queue is finished (for debug purposes
         // only)
         Future<Boolean> firstFuture = threadQueue.peek();
         if (firstFuture != null)
            logger.log(Level.INFO, "First Task Running==" + Boolean.toString(!firstFuture
               .isCancelled() && !firstFuture.isDone()));
         else
            logger.log(Level.INFO, "firstFuture==null");

         // submit a Callable to the thread pool for execution
         Future<Boolean> nextFuture = executor.submit(workerTask);

         // add next future to queue
         threadQueue.add(nextFuture);
      }
   }

   private class StopThreadListener implements ActionListener
   {
      // if we start more than one thread before interrupting
      // then we will only be able to stop latest one (unless we force
      // close app) from the layout XML
      public void actionPerformed(ActionEvent e)
      {
         // if we have a thread in the queue then interrupt it and remove
         // from queue
         Future<Boolean> front = threadQueue.peek();
         if (front != null)
         {
            front.cancel(true);
            threadQueue.remove();
         }
      }
   }

   public ThreadTestAppPooled()
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            JButton startButton = new JButton("start thread");
            startButton.addActionListener(new StartThreadListener());
            JButton stopButton = new JButton("stop thread");
            stopButton.addActionListener(new StopThreadListener());
            setLayout(new FlowLayout());
            add(startButton);
            add(stopButton);
            add(textArea);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
         }
      });

   }

   public static void main(String[] args)
   {
      new ThreadTestAppPooled();
   }
}