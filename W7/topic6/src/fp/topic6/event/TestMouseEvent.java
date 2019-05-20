package fp.topic6.event;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

public class TestMouseEvent extends SimpleJFrame
{
   public TestMouseEvent()
   {
      setLayout(new FlowLayout());
      // event source is the JFrame
      addMouseListener(new TestMouseListener());
      addMouseMotionListener(new TestMouseMotionListener());
      addMouseWheelListener(new TestMouseWheelListener());
      super.showFrame();
   }

   public static void main(String args[])
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new TestMouseEvent();
         }
      });
   }
}

class MouseReporter
{
   public void report(MouseEvent e)
   {
      int clickCount = e.getClickCount();
      int mods = e.getModifiersEx();
      Point p = e.getPoint();
      boolean isPopupTrigger = e.isPopupTrigger();
      String s = "mouse ";

      if ((mods & InputEvent.BUTTON3_DOWN_MASK) != 0)
         s += "button 3";
      else if ((mods & InputEvent.BUTTON2_DOWN_MASK) != 0)
         s += "button 2";
      else if ((mods & InputEvent.BUTTON1_DOWN_MASK) != 0)
         s += "button 1";
      else
         s += e.getID() != MouseEvent.MOUSE_WHEEL ? "cursor" : "";

      // use bit masking to check for modifier key
      if (((e.getModifiersEx() & KeyEvent.ALT_DOWN_MASK)) != 0)
         System.out.println("** Modifier bit masking shows ALT");

      // used for demonstrative purposes only
      // (should really go in the respective event handler methods)
      switch (e.getID())
      {
      case MouseEvent.MOUSE_PRESSED:
         s += " pressed";
         break;
      case MouseEvent.MOUSE_RELEASED:
         s += " released";
         break;
      case MouseEvent.MOUSE_CLICKED:
         s += " clicked";
         break;
      case MouseEvent.MOUSE_MOVED:
         s += " moved";
         break;
      case MouseEvent.MOUSE_ENTERED:
         s += " entered";
         break;
      case MouseEvent.MOUSE_EXITED:
         s += " exited";
         break;
      case MouseEvent.MOUSE_DRAGGED:
         s += " dragged";
         break;
      case MouseEvent.MOUSE_WHEEL:
         s += "wheel";
         break;
      }
      System.out.println(s + " at:  " + p);
      System.out.println(" click count:  " + clickCount);
      System.out.println(" is popup trigger:  " + isPopupTrigger);
      System.out.println();
   }
}

class TestMouseListener implements MouseListener
{
   private static final MouseReporter reporter = new MouseReporter();

   @Override
   public void mouseClicked(MouseEvent e)
   {
      reporter.report(e);
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      reporter.report(e);
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      reporter.report(e);
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      reporter.report(e);
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      reporter.report(e);
   }
}

class TestMouseMotionListener implements MouseMotionListener
{
   private static final MouseReporter reporter = new MouseReporter();

   @Override
   public void mouseDragged(MouseEvent e)
   {
      reporter.report(e);
   }

   @Override
   public void mouseMoved(MouseEvent e)
   {
      // can uncomment but will SPAM output!
      //reporter.report(e);
   }
}

class TestMouseWheelListener implements MouseWheelListener
{
   private static final MouseReporter reporter = new MouseReporter();

   @Override
   public void mouseWheelMoved(MouseWheelEvent e)
   {
      reporter.report(e);
   }
}
