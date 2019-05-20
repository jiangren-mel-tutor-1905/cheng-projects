package fp.topic7.mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fp.topic7.mvc.model.Model;
import fp.topic7.mvc.view.ButtonView;

public class ButtonController2 extends MouseAdapter
{
	private Model model;
	private ButtonView source;

	public ButtonController2(Model model, ButtonView source)
	{
		this.model = model;
		this.source = source;
	}

	public void mouseEntered(MouseEvent e)
	{
		// note the controller is simpler when we already have the required refs
		// also coupling is more explicit and easier to manage
		model.setData(source.getViewNumber(), source.getText() + " moused");
	}
}
