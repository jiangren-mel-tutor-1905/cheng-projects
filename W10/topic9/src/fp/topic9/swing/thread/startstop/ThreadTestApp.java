// Threading example by Caspar Ryan
// Not using MVC, could benefit from refactoring into separate classes!
package fp.topic9.swing.thread.startstop;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ThreadTestApp extends JFrame
{
   private Thread testThread;

   // use the Java system logger instead of println
   private Logger logger = Logger.getLogger(this.getClass().getName());

   private class StartThreadListener implements ActionListener
   {
      // if we start more than one thread before interrupting
      // then we will only be able to stop latest one (unless we force
      // close app)
      public void actionPerformed(ActionEvent e)
      {
         // check thread is really finished
         if (testThread != null)
            logger.log(Level.INFO, "testThread.isAlive()==" + testThread.isAlive());
         else
            logger.log(Level.INFO, "testThread==null");

         // create Thread from Runnable (WorkTask)
         testThread = new Thread(new WorkerTask(null));
         // make sure thread will be killed if app is unexpectedly killed
         testThread.setDaemon(true);
         testThread.start();
      }
   }

   private class StopThreadListener implements ActionListener
   {
      // if we start more than one thread before interrupting
      // then we will only be able to stop latest one (unless we force
      // close app)
      public void actionPerformed(ActionEvent e)
      {
         testThread.interrupt();
      }
   }

   public ThreadTestApp()
   {
      JButton startButton = new JButton("start thread");
      startButton.addActionListener(new StartThreadListener());
      JButton stopButton = new JButton("stop thread");
      stopButton.addActionListener(new StopThreadListener());
      setLayout(new FlowLayout());
      add(startButton);
      add(stopButton);
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
            new ThreadTestApp();
         }
      });
   }
}