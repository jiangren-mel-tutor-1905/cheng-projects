package fp.topic6.inner.named;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// examples to show different approaches to using listener classes
// this example shows named inner listener classes 
// one listener instance per event source
//
// NOTE code only intended to show structure, not complete functionality of a custom 3D button
public class ThreeDButton extends Canvas
// this is the 'outer' or 'enclosing' class and is the View in MVC
{
   // the listener is a named 'inner' or 'enclosed' class
   class ThreeDButtonMouseListener extends MouseAdapter
   {
      // event handler method (method of the listener)
      @Override
      public void mousePressed(MouseEvent event)
      {
         // call methods on event source (view in MVC)
         // explicit outer (ThreeDButton.this.) reference is optional .. see
         // mouseClicked below
         ThreeDButton.this.paintBorderInset();
      }

      @Override
      public void mouseClicked(MouseEvent event)
      {
         paintBorderRaised();
      }

      @Override
      public void mouseReleased(MouseEvent event)
      {
         paintBorderRaised();
      }

      @Override
      public void mouseDragged(MouseEvent event)
      {
         if (contains(event.getX(), event.getY()))
         {
            if (getState() == ThreeDButton.BORDER_RAISED)
               paintBorderInset();
         }
         else
         {
            // can refer to private field of enclosing class
            if (state == ThreeDButton.BORDER_INSET)
               paintBorderRaised();
         }
      }

      @Override
      public void mouseMoved(MouseEvent event)
      {
      }
   }

   public static final int BORDER_INSET = 0;

   public static final int BORDER_RAISED = 1;

   private int state = BORDER_RAISED;

   private ThreeDButtonMouseListener mouseListener = new ThreeDButtonMouseListener();

   public ThreeDButton()
   {
      // add an instance of the named inner class listener to
      // each instance of the event source
      addMouseListener(mouseListener);
      addMouseMotionListener(mouseListener);
   }

   // event source method
   public void paintBorderInset()
   {
      // ...
      paintBorderRaised();
   }

   public void paintBorderRaised()
   {
      // ...
   }

   public int getState()
   {
      // ...
      return state;
   }
}
