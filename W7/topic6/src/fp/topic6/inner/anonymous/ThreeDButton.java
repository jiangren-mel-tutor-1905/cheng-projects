package fp.topic6.inner.anonymous;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// examples to show different approaches to using listener classes
// this example shows anonymous inner listener classes 
// one listener instance per event source
//
// NOTE code only intended to show structure, not complete functionality of a custom 3D button
public class ThreeDButton extends Button
// this is the 'outer' or 'enclosing' class and is the View in MVC
{
   public static final int BORDER_INSET = 0;

   public static final int BORDER_RAISED = 1;

   private int state = BORDER_RAISED;

   public ThreeDButton()
   {
      // anonymous classes handy for this sort of call
      addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
            paintBorderInset();
         }
      });

      // not very good for something like this!
      MouseAdapter adapter = new MouseAdapter()
      {
         // event handler method (method of the listener)
         @Override
         public void mousePressed(MouseEvent event)
         {
            // call methods on event source (view in MVC)
            // explicit outer (ThreeDButton.this.) reference is optional ..
            // see mouseClicked below
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
               if (getState() == ThreeDButton.BORDER_INSET)
                  paintBorderRaised();
            }
         }

         @Override
         public void mouseMoved(MouseEvent event)
         {
         }
      };

      // add an instance of the *anonymous* inner class listener to
      // each instances of the event source
      addMouseListener(adapter);

      // because we are using anonymous classes and connat reuse we must do the MouseMotionAdapter
      // separately
      addMouseMotionListener(adapter);
   }

   // event source method
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
}
