package fp.topic5.layout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//note we are extending an abstract class for some 'boilerplate' code
public class BorderLayoutExample extends SimpleJFrame
{
	public BorderLayoutExample()
	{
		// we are using an extra panel this time (not strictly necessary here but shows nesting of containers)
		Container buttonPanel = new JPanel();
		// declare some components (note use of local scope for encapsulation)
		JButton north = new JButton("north");
		// north2 = new Button("north2");
		JButton east = new JButton("east");
		JButton west = new JButton("west text is longer");
		JButton center = new JButton("center");
		JButton south = new JButton("south");

		buttonPanel.setLayout(new BorderLayout(2, 2));
		buttonPanel.add(north, BorderLayout.NORTH);
		// buttonPanel.add(north2, BorderLayout.NORTH);
		buttonPanel.add(south, BorderLayout.SOUTH);
		buttonPanel.add(east, BorderLayout.EAST);
		buttonPanel.add(west, BorderLayout.WEST);
		buttonPanel.add(center, BorderLayout.CENTER);

		// add container with the buttons to the frame
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.CENTER);
		// make frame visible
		super.showFrame();
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new BorderLayoutExample();
			}
		});
	}
}
