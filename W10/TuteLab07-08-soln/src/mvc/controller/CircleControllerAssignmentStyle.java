package mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mvc.model.Model;
import mvc.view.AppFrame;

// Assignment style controller approach (ADVANTAGE: explicit coupling!)
public class CircleControllerAssignmentStyle extends MouseAdapter
{
	private int viewNumber;
	private AppFrame appFrame;
	private Model model;

	// alternative controller approach maintains necessary references (one instance per CircleView)
	public CircleControllerAssignmentStyle(int viewNumber, AppFrame appFrame, Model model)
	{
		this.viewNumber = viewNumber;
		this.appFrame = appFrame;
		this.model = model;
	}

	public void mouseEntered(MouseEvent e)
	{
		// set model value for color (selected color is retrieved via the Frame)
		// NOTE: this is easier when we already have the required references
		model.setColor(viewNumber, appFrame.getSelectedColor());
	}
}
