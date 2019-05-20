package fp.topic6.listener.separate;

import java.awt.Canvas;

// examples to show different approaches to using listener classes
// this example shows a separate listener class but with a *shared instance* between
// event sources
//
// NOTE code only intended to show structure, not complete functionality of a custom 3D button
public class ThreeDButton extends Canvas
// extends Canvas, is a graphical class therefore View in MVC
{
	public static final int BORDER_INSET = 0;

	public static final int BORDER_RAISED = 1;

	private int state = BORDER_RAISED;

	// static means we only have one *shared instance* of this attribute for all
	// ThreeDButton instances
	private static ThreeDButtonListener threeDlistener = new ThreeDButtonListener();

	public ThreeDButton()
	{
		// add the shared instance of listener to all instances of the event
		// source
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

	// call this to use a different listener instance
	public void addThreeDButtonListener(ThreeDButtonListener threeDlistener)
	{
		removeMouseListener(ThreeDButton.threeDlistener);
		removeMouseMotionListener(ThreeDButton.threeDlistener);
		addMouseListener(threeDlistener);
		addMouseMotionListener(threeDlistener);
	}
}
