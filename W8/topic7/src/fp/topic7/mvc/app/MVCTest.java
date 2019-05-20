package fp.topic7.mvc.app;

import javax.swing.SwingUtilities;

import fp.topic7.mvc.view.AppFrame;

// MVC example by Caspar
public class MVCTest
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new AppFrame();
			}
		});
	}
}
