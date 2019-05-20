package fp.topic7.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

@SuppressWarnings("deprecation")
class EventSource extends Observable implements Runnable
{
   @Override
   public void run()
   {
      try
      {
         final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         while (true)
         {
            String response = br.readLine();

            // methods inherited from java.util.Observable
            setChanged();
            notifyObservers(response); // observers update() called
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
