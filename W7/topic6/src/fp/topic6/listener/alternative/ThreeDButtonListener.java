package fp.topic6.listener.alternative;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ThreeDButtonListener extends MouseAdapter
//extends/implements listeners, is a separate Controller in MVC
{
   private ThreeDButton button;

   // store the instance of the event source (one per listener instance) 
   public ThreeDButtonListener(ThreeDButton button)
   {
      this.button = button;
   }

   @Override
   public void mousePressed(MouseEvent event)
   {
      // call method on event source (view in MVC)
      // we do not need to call getSource() since we have already stored the event source in "button"
      button.paintBorderInset();
   }

   @Override
   public void mouseClicked(MouseEvent event)
   {
      button.paintBorderRaised();
   }

   @Override
   public void mouseReleased(MouseEvent event)
   {
      button.paintBorderRaised();
   }

   @Override
   public void mouseDragged(MouseEvent event)
   {
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
