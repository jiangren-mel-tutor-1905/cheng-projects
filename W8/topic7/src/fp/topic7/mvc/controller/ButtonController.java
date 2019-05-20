package fp.topic7.mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fp.topic7.mvc.model.Model;
import fp.topic7.mvc.model.ModelImpl;
import fp.topic7.mvc.view.ButtonView;

public class ButtonController extends MouseAdapter
{
	public void mouseEntered(MouseEvent e)
	{
		// the advantage of using the registry is that it makes it easier
		// to substitute a different model (e.g. for testing)
		// Model model=Registry.getModel();
		Model model = ModelImpl.getSingletonInstance();

		// since only one instance we need to find which button triggered event
		ButtonView source = (ButtonView) e.getSource();
		model.setData(source.getViewNumber(), source.getText() + " moused");
	}
}
