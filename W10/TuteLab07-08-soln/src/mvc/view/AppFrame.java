package mvc.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mvc.model.Model.Color;

public class AppFrame extends JFrame
{
	private static AppFrame singletonInstance = new AppFrame();
	private CircleToolBar circleToolBar;

	// see model class for details of Singleton pattern
	private AppFrame()
	{
		super("AWT/Swing Tutelab Exercises");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static AppFrame getSingletonInstance()
	{
		return singletonInstance;
	}

	// populate Frame in a separate method so that Registry can be initialised to set up global refs
	public void populate()
	{
		circleToolBar = new CircleToolBar();
		setLayout(new BorderLayout());
		add(circleToolBar, BorderLayout.NORTH);
		add(new CirclePanel(), BorderLayout.CENTER);
		// the StatusBarPanel listens to notifications from the CircleToolBar
		add(new StatusBarPanel(circleToolBar), BorderLayout.EAST);
		// need to re-layout after new components added
		revalidate();
	}

	// rather than expose the CircleToolBar the frame can perform actions on its behalf
	public Color getSelectedColor()
	{
		// convert String representation from actionCommand into a String
		return Enum.valueOf(Color.class, circleToolBar.getSelectedAction());
	}
}