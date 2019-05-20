package fp.topic6.event;

import java.awt.Window;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingUtilities;

public class TestWindowEvent extends SimpleJFrame
{
   public TestWindowEvent()
   {
      setTitle("WindowListener test");
      addWindowListener(new TestWindowListener());
      addComponentListener(new TestComponentListener());
      super.showFrame();
      // maximize the frame
      setExtendedState(MAXIMIZED_BOTH);
   }

   public static void main(String args[])
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new TestWindowEvent();
         }
      });
   }
}

class TestWindowListener implements WindowListener
{
   @Override
   public void windowActivated(WindowEvent e)
   {
      System.out.println("window activated");
   }

   @Override
   public void windowClosed(WindowEvent e)
   {
      System.out.println("window closed");
      System.exit(0);
   }

   @Override
   public void windowClosing(WindowEvent e)
   {
      System.out.println("window closing ...");
      Window w = e.getWindow();
      w.dispose();
   }

   @Override
   public void windowDeactivated(WindowEvent e)
   {
      System.out.println("window deactivated");
   }

   @Override
   public void windowIconified(WindowEvent e)
   {
      System.out.println("window iconified");
   }

   @Override
   public void windowDeiconified(WindowEvent e)
   {
      System.out.println("window deiconified");
   }

   @Override
   public void windowOpened(WindowEvent e)
   {
      System.out.println("window opened");
   }
}

class TestComponentListener implements ComponentListener
{
   @Override
   public void componentResized(ComponentEvent e)
   {
      System.out.println("window resized, size=" + e.getComponent().getSize());
   }

   @Override
   public void componentMoved(ComponentEvent e)
   {
      System.out.println("window moved, position=" + e.getComponent().getLocation());
   }

   @Override
   public void componentShown(ComponentEvent e)
   {
      System.out.println("window shown");
   }

   @Override
   public void componentHidden(ComponentEvent e)
   {
      System.out.println("window hidden");
   }
}