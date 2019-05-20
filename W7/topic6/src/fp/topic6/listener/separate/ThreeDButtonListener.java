package fp.topic6.listener.separate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ThreeDButtonListener extends MouseAdapter
// extends/implements listeners, is a separate Controller in MVC
{
   // event handler method
   @Override
   public void mousePressed(MouseEvent event)
   {
      // because we call getSource() we can share an instance of the listener
      ThreeDButton button = (ThreeDButton) event.getSource();
      // call method on event source (view in MVC)
      button.paintBorderInset();
   }

   @Override
   public void mouseClicked(MouseEvent event)
   {
      ThreeDButton button = (ThreeDButton) event.getSource();
      button.paintBorderRaised();
   }

   @Override
   public void mouseReleased(MouseEvent event)
   {
      ThreeDButton button = (ThreeDButton) event.getSource();
      button.paintBorderRaised();
   }

   @Override
   public void mouseDragged(MouseEvent event)
   {
      ThreeDButton button = (ThreeDButton) event.getSource();

      if (button.contains(event.getX(), event.getY()))
      {
         if (button.getState() == ThreeDButton.BORDER_RAISED)
            button.paintBorderInset();
      }
      else
      {
         if (button.getState() == ThreeDButton.BORDER_INSET)
            button.paintBorderRaised();
      }
   }

   @Override
   public void mouseMoved(MouseEvent event)
   {
   }
}
