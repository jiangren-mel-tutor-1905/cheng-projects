// Basic AWT Frame/Dialog behaviour
// Also demonstrates anonymous and standard inner classes for event handling
// Written by Caspar Ryan
package fp.topic5.dialog;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

class TestQuestionAWT
{
	private TestQuestionAWT()
	{
		// create a frame and make it visible
		final Frame appFrame = new Frame("Test Question Dialog");
		appFrame.setSize(320, 200);
		appFrame.setVisible(true);

		// create a new custom dialog box (based on our custom QuestionDialogAWT
		// class)
		QuestionDialogAWT questionDialog = new QuestionDialogAWT(appFrame);

		// show modal thread blocking behaviour
		System.out.println("blocked");
		Utils.setDialogLocation(appFrame, questionDialog);
		questionDialog.setVisible(true);
		System.out.println("unblocked");

		// this is called once the question is answered (i.e. dialog box is
		// dismissed)
		if (questionDialog.yes())
		{
			appFrame.dispose();
			System.exit(0);
		}

		// display a file dialog
		FileDialog dialog = new FileDialog(appFrame);
		dialog.setVisible(true);
		System.out.println(dialog.getDirectory() + dialog.getFile());

		// add a listener so we can exit the app
		appFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				appFrame.dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[])
	{
		// GUI code should run on the AWT Event dispatch/UI Thread
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new TestQuestionAWT();
			}
		});
	}
}
