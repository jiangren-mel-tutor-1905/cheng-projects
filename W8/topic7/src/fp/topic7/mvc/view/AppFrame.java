package fp.topic7.mvc.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

import fp.topic7.mvc.model.Model;

public class AppFrame extends JFrame
{
	public AppFrame()
	{
		super("Test MVC");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populate();
		setVisible(true);
	}

	public void populate()
	{
		setLayout(new GridLayout((int) Math.sqrt(Model.NUM_VIEWS), (int) Math.sqrt(Model.NUM_VIEWS)));

		for (int i = 0; i < Model.NUM_VIEWS; i++)
			// add the new button to the frame
			add(new ButtonView(i));
	}
}