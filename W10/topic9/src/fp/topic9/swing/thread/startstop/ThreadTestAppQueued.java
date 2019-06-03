// Threading example by Caspar Ryan
// Not using MVC, could benefit from refactoring into separate classes!
package fp.topic9.swing.thread.startstop;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ThreadTestAppQueued extends JFrame
{
   // maintain a queue of running threads (FIFO)
   // LinkedBlockingQueue is thread safe (standard LinkedList is not)
   private Queue<Thread> threadQueue = new LinkedBlockingQueue<Thread>();

   private JTextArea textArea = new JTextArea(1, 20);

   // use the Java system logger instead of println
   private Logger logger = Logger.getLogger(this.getClass().getName());

   private class StartThreadListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // check if thread at head of queue is finished (for debug purposes
         // only)
         Thread firstThread = threadQueue.peek();
         if (firstThread != null)
            logger.log(Level.INFO, "firstThread.isAlive()==" + firstThread.isAlive());
         else
            logger.log(Level.INFO, "firstThread==null");

         // create the Thread from a Runnable (WorkerTask)
         Thread newThread = new Thread(new WorkerTask(textArea));
         // add new thread to queue
         threadQueue.add(newThread);

         // make sure thread will be killed if app is unexpectedly killed
         newThread.setDaemon(true);
         newThread.start();
      }
   }

   private class StopThreadListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // if we have a thread in the queue then interrupt it and remove
         // from queue
         Thread front = threadQueue.peek();
         if (front != null)
         {
            front.interrupt();
            threadQueue.remove();
         }
      }
   }

   public ThreadTestAppQueued()
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

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new ThreadTestAppQueued();
         }
      });
   }
}