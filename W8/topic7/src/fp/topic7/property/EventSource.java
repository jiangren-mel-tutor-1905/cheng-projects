package fp.topic7.property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EventSource implements Runnable
{
   private final PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
   public static final String PROPERTY_NAME = "SomeProperty";
   private String response;

   @Override
   public void run()
   {
      try
      {
         final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         while (true)
         {
            String oldResponse = response;
            response = br.readLine();

            // alternative to Observable
            propertySupport.firePropertyChange(PROPERTY_NAME, oldResponse, response);
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   // forward to PropertyChangeSupport
   public void addPropertyChangeListener(String property, PropertyChangeListener listener)
   {
      propertySupport.addPropertyChangeListener(property, listener);
   }

   public void removePropertyChangeListener(String property, PropertyChangeListener listener)
   {
      propertySupport.removePropertyChangeListener(listener);
   }
}
