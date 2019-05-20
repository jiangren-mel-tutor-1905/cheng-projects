package fp.topic6.event.action;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fp.topic6.event.SimpleJFrame;

// refactored by Caspar
// show that we can add an ActionListener to different components and can even make our own ActionEvents (on the JList)!
public class ActionListenerExample extends SimpleJFrame
{
	static public void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new ActionListenerExample();
			}
		});
	}

	public ActionListenerExample()
	{
		JButton button = new JButton("Activate Me");
		JList<String> list = new JList<String>();
		// put a border on the JList
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JTextField textfield = new JTextField("Some Text", 25);
		JMenuItem menuItem = new JMenuItem("MenuItem");

		setTitle("Action Example");
		JMenuBar mbar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.add(menuItem);
		mbar.add(menu);
		setJMenuBar(mbar);

		// populate the JList (note the generics)
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("item 1");
		listModel.addElement("item 2");
		listModel.addElement("item 3");
		listModel.addElement("item 4");
		listModel.addElement("item 5");
		list.setModel(listModel);

		// layout and add components
		setLayout(new FlowLayout());
		add(button);
		add(list);
		add(textfield);

		// declare once so we can reuse the ActionListener instance
		DebugActionListener debugActionListener = new DebugActionListener();
		button.addActionListener(debugActionListener);
		textfield.addActionListener(debugActionListener);
		menuItem.addActionListener(debugActionListener);
		// extra work to add to JList (see DebugActionListener class)
		DebugActionListener.addActionListenerToJList(list, debugActionListener);

		super.showFrame();
	}
}
