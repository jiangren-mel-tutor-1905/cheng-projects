package fp.topic9.swing.thread;

import java.util.List;

import javax.swing.SwingWorker;

//multi-threaded Swing example using SwingWorker
//by Caspar Ryan
// SwingWorker<T,V>
// T - the result type returned by this SwingWorker's doInBackground and get methods
// V - the type used for carrying out intermediate results by this SwingWorker's publish and process methods
class SimpleSwingWorker extends SwingWorker<Void, Integer>
{
   private WorkerFrame workerFrame;

   // pass in view param so we can call methods on it to do UI updates
   public SimpleSwingWorker(WorkerFrame workerFrame)
   {
      this.workerFrame = workerFrame;
   }

   @Override
   // do in background runs in worker thread
   public Void doInBackground()
   {
      // this will delay but will not block UI since we are on a separate
      // thread
      //      Utilities.wait5secs();

      for (int i = 1; i <= 100; i++)
      {
         try
         {
            Thread.sleep(40);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
         // set progress fires the property change listener on the UI thread
         // can use either of the following two approaches (see WorkerActionListener)
         setProgress(i);
         // firePropertyChange("progress", getProgress(), i);

         // publish(V...) executes process(List<V>) method on the UI thread (note
         // the var args) on publish is an optimisation to coalesce multiple publish calls
         publish(i);

         // INCORRECT USAGE DEMO:
         // what happens if we call process directly?
         // List<Integer> tempList = new ArrayList<Integer>();
         // tempList.add(i);
         // process(tempList);
      }
      System.out.println("doInBackground() has finished .. done will get called");
      return null;
   }

   // executes on the UI (AWT Event Dispatch) thread (note the var args)
   // is an optimisation to coalesce multiple publish calls
   @Override
   protected void process(List<Integer> params)
   {
      for (Integer i : params)
         workerFrame.append(String.format("%d %s", i, ((i % 10) == 0) ? "\n" : ""));
   }

   // Executed on the UI (AWT Event Dispatch) after doInBackground() is finished
   @Override
   protected void done()
   {
      System.out.println("Done called .. doInBackground() has finished");
   }
}
