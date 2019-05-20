package fp.topic6.inner.combined;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// examples to show different approaches to using listener classes
// this example shows a combined event source and listener 
//
// NOTE code only intended to show structure, not complete functionality of a custom 3D button
public class ThreeDButton extends Canvas implements MouseListener, MouseMotionListener
// this class extends/implements multiple class/interfaces
// serves as event source AND listener (therefore View and Controller in MVC)
{
   public static final int BORDER_INSET = 0;

   public static final int BORDER_RAISED = 1;

   private int state = BORDER_RAISED;

   public ThreeDButton()
   {
      // this instance is both a source and listener
      // we add the listener (this) to the source (this)
      this.addMouseListener(this);
      // note that the first implicit 'this' is optional, the second is not
      addMouseMotionListener(this);
   }

   // this is a method of the event source
   public void paintBorderInset()
   {
      // ...
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

   // this is a method of the listener
   @Override
   public void mousePressed(MouseEvent event)
   {
      // call methods on event source (view in MVC)
      this.paintBorderInset();
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
         if (getState() == ThreeDButton.BORDER_INSET)
            paintBorderRaised();
      }
   }

   @Override
   public void mouseMoved(MouseEvent event)
   {
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
   }
}
