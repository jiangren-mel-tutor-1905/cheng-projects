package fp.topic7.observer;

// Observer example from FP notes
// refactored by Caspar
public class TestObserver
{
   // Observer deprecated in Java 9 but not scheduled for removal
   @SuppressWarnings("deprecation")
   public static void main(String args[]) throws Exception
   {
      System.out.println("Enter Text and press <ENTER> While the Application is Running!");

      // create an event source - reads from stdin
      final EventSource observable = new EventSource();

      // add the observer to the event source (subscribe to notifications)
      observable.addObserver(new EventObserver());

      // start the event loop which will fire notifications at the observer
      Thread eventThread = new Thread(observable);
      // Daemon thread will exit when main thread exits
      // i.e. our event source loop will finish
      eventThread.setDaemon(true);
      eventThread.start();

      // do something on the main thread while we wait for notifications
      for (int i = 1; i <= 100; i++)
      {
         Thread.sleep(100);
         // line break every 20 iterations
         System.out.print(i + " " + ((i % 20 == 0) ? '\n' : ""));
      }
   }
}
