package fp.topic7.property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class EventObserver implements PropertyChangeListener
{
   @Override
   public void propertyChange(PropertyChangeEvent evt)
   {
      System.out.println("\nReceived Response: " + evt.getNewValue());
   }
}
