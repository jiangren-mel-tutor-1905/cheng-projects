// Basic Swing Frame/Dialog behaviour
// Compare with TestQuestionAWT
// Written by Caspar Ryan
package fp.topic5.dialog;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class TestQuestionSwing
{
	private TestQuestionSwing()
	{
		// create a frame and make it visible
		final JFrame appFrame = new JFrame("Test Question Dialog (Swing)");
		appFrame.setBounds(100, 100, 800, 600);
		appFrame.setVisible(true);
		// no need for window listener on JFrame
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create a new custom dialog box (based on our custom QuestionDialogAWT
		// class)
		QuestionDialogSwing questionDialog = new QuestionDialogSwing(appFrame);

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
	}

	public static void main(String args[])
	{
		// GUI code should run on the AWT Event dispatch/UI Thread
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new TestQuestionSwing();
			}
		});
	}
}
