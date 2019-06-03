package mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import mvc.model.Model.Color;
import mvc.view.factory.ImageIconFactory;

public class CircleToolBar extends JToolBar implements ActionListener
{
	private AbstractButton[] buttons = new AbstractButton[Color.values().length];
	private ButtonGroup group = new ButtonGroup();

	// instead of Observer we will use PropertyChangeEvents to notify listener (StatusBar) of selection
	// see inherited java.awt.Container.addPropertyChangeListener(...) overloads
	public static final String COLOR_PROPERTY = "color";
	// required for the propertyChangeEvent
	private String lastSelectedColor;

	public CircleToolBar()
	{
		// i is the index for the toolbar buttons
		int i = 0;
		// loop through the Color enum
		for (Color color : Color.values())
		{
			// create button with an image from the factory class
			buttons[i] = new JToggleButton(ImageIconFactory.getImageIcon(color));
			// set action command so we can easily identify this button
			buttons[i].setActionCommand(color.toString());
			// set border style
			buttons[i].setBorder(BorderFactory.createRaisedBevelBorder());
			// add action listener to fire property changes when selected
			buttons[i].addActionListener(this);
			// set the first button as the default selection
			if (i == 0)
				buttons[i].setSelected(true);

			// add buttons to group for radio behaviour
			group.add(buttons[i]);
			// add button to toolbar
			add(buttons[i]);
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// check for initial case and also for value change
		if (lastSelectedColor == null || (lastSelectedColor != null && !lastSelectedColor.equals(getSelectedAction())))
		{
			// notify PropertyChangeListeners (StatusBar in this case)
			firePropertyChange(COLOR_PROPERTY, lastSelectedColor, getSelectedAction());
			// for next time
			lastSelectedColor = getSelectedAction();
		}
	}

	public String getSelectedAction()
	{
		return group.getSelection().getActionCommand();
	}
}
