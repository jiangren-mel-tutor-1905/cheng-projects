package mvc.app;

import javax.swing.SwingUtilities;

import mvc.model.Registry;
// AWT/Swing MVC test application by Caspar 
// Solution to tutelabs 6-8
// Demonstrates the following:
// MVC, Observer pattern, Registry for handling references 
// Factory class with lazy instatiation, Singleton pattern and assert keyword

public class MVCTest
{
	public static void main(String[] args)
	{
		// We access our main view and model through the singleton Registry
		// class
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Registry.getAppFrame().populate();
			}
		});
	}
}
