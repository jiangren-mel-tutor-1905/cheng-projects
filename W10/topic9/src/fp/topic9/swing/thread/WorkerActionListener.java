package fp.topic9.swing.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.SwingWorker;

public class WorkerActionListener implements ActionListener
{
   private WorkerFrame workerFrame;

   public WorkerActionListener(WorkerFrame workerFrame)
   {
      this.workerFrame = workerFrame;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // create new instance since can only execute once
      SwingWorker<?, ?> task = new SimpleSwingWorker(workerFrame);
      // optional, used for the progress bar only
      task.addPropertyChangeListener(new PropertyChangeListener()
      {
         // propertyChange called on AWT Event Dispatch thread
         public void propertyChange(PropertyChangeEvent evt)
         {
            if (evt != null && "progress".equals(evt.getPropertyName()) && evt
               .getNewValue() != null)
               workerFrame.setProgress((Integer) evt.getNewValue());
         }
      });

      // uncomment to hang UI
      //      Utilities.wait5secs();
      // NOTE: can only be executed once!
      task.execute();
   }
}
