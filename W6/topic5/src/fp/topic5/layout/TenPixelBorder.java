package fp.topic5.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;

public class TenPixelBorder extends JPanel
{
	public TenPixelBorder(Component borderMe)
	{
		setLayout(new BorderLayout());
		add(borderMe, BorderLayout.CENTER);
	}

	// override paintComponent() instead of paint() for Swing
	public void paintComponent(Graphics g)
	{
		Dimension mySize = getSize();
		Insets myInsets = getInsets();

		g.setColor(Color.gray);

		// Top Inset area
		g.fillRect(0, 0, mySize.width, myInsets.top);

		// Left Inset area
		g.fillRect(0, 0, myInsets.left, mySize.height);

		// Right Inset area
		g.fillRect(mySize.width - myInsets.right, 0, myInsets.right,
				mySize.height);

		// Bottom Inset area
		g.fillRect(0, mySize.height - myInsets.bottom, mySize.width,
				mySize.height);
	}

	@Override
	// provides a ten pixel border
	public Insets getInsets()
	{
		return new Insets(10, 10, 10, 10);
	}
}
