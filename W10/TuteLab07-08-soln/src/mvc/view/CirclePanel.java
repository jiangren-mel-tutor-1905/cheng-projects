package mvc.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import mvc.model.Model;

public class CirclePanel extends JPanel
{
	public CirclePanel()
	{
		setLayout(new GridLayout((int) Math.sqrt(Model.NUM_VIEWS), (int) Math
				.sqrt(Model.NUM_VIEWS)));

		for (int i = 0; i < Model.NUM_VIEWS; i++)
			// add the new button to the frame
			add(new CircleView(i));
	}
}
