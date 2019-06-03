package fp.topic9.swing.thread;

import javax.swing.SwingUtilities;

// multi-threaded Swing example using SwingWorker
// by Caspar
public class TestSwingWorker
{
	public static void main(String[] args)
	{
		// do all GUI creation on the event dispatch thread
		// NOTE: Variable scope/refs are implicit to the event queue
		// take a look in the debugger to investigate further
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new WorkerFrame();
			}
		});

		//not technically correct because it updates UI on a worker thread
		//		new Thread(new Runnable()
		//		{
		//			@Override
		//			public void run()
		//			{
		//				new WorkerFrame();
		//			}
		//
		//		}).start();
	}
}