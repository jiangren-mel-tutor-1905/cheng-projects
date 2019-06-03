package mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mvc.model.Model;
import mvc.model.Registry;
import mvc.view.CircleView;

public class CircleController extends MouseAdapter
{
	public void mouseEntered(MouseEvent e)
	{
		// the advantage of using the registry over direct singleton is that it makes it easier
		// to substitute a different model (e.g. for testing)
		Model model = Registry.getModel();
		// or get the model directly using Singleton
		//Model model = ModelImpl.getSingletonInstance();

		// since only one instance we need to find which button triggered event
		CircleView source = (CircleView) e.getSource();
		// set model value for color (selected color is retrieved via the Frame)
		model.setColor(source.getViewNumber(), Registry.getAppFrame().getSelectedColor());
	}
}
