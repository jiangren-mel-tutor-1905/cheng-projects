package mvc.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBarPanel extends JPanel implements PropertyChangeListener
{
	private JLabel statusLabel1 = new JLabel("status 1", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("status 2", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("status 3", JLabel.RIGHT);

	public StatusBarPanel(CircleToolBar circleToolbar)
	{
		// listen for property changes on the toolbar when the selected color changes
		// this is a an alternative approach to Observable/Observer
		circleToolbar.addPropertyChangeListener(CircleToolBar.COLOR_PROPERTY, this);

		setLayout(new GridLayout(1, 3));

		statusLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		statusLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		statusLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// set initial selected color in status bar segment 1
		setStatus1(circleToolbar.getSelectedAction());

		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
	}

	// helper method since called from multiple places
	private void setStatus1(String colorString)
	{
		statusLabel1.setText(String.format("%s selected", colorString));
	}

	@Override
	// we update status segment 1 when the toolbar color selection changes
	public void propertyChange(PropertyChangeEvent event)
	{
		if (event.getPropertyName().equals(CircleToolBar.COLOR_PROPERTY) && event.getNewValue() != null)
			setStatus1(event.getNewValue().toString());
	}

	// we could add setter methods for the status segments but currently unused so I have not added them .. 
}
