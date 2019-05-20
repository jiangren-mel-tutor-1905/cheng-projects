package fp.topic6.listener.alternative;

import java.awt.Canvas;

//examples to show different approaches to using listener classes
//this example shows a *separate listener* class with a *separate instance* 
//for each event source
//
//NOTE code only intended to show structure, not complete functionality of a custom 3D button
public class ThreeDButton extends Canvas
// extends Canvas, is a graphical class therefore View in MVC
{
	public static final int BORDER_INSET = 0;
	public static final int BORDER_RAISED = 1;

	private int state = BORDER_RAISED;

	public ThreeDButton()
	{
		// create a separate listener instance and pass a reference to
		// the event source (this)
		ThreeDButtonListener threeDlistener = new ThreeDButtonListener(this);
		addMouseListener(threeDlistener);
		addMouseMotionListener(threeDlistener);
	}

	// methods that affect the appearance of the button
	// called from the listener (controller of MVC)
	public void paintBorderInset()
	{
		// ...
	}

	public void paintBorderRaised()
	{
		// ...
	}

	public int getState()
	{
		// ...
		return state;
	}
}
