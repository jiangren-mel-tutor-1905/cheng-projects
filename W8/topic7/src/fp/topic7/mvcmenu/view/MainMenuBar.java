package fp.topic7.mvcmenu.view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import fp.topic7.mvcmenu.controller.CloseActionListener;
import fp.topic7.mvcmenu.controller.ExitActionListener;
import fp.topic7.mvcmenu.controller.NewActionListener;
import fp.topic7.mvcmenu.controller.OpenActionListener;
import fp.topic7.mvcmenu.controller.SaveActionListener;

public class MainMenuBar extends JMenuBar
{
	public MainMenuBar(MainAppFrame frame)
	{
		JMenu fileMenu = new JMenu("File");

		fileMenu.setMnemonic(KeyEvent.VK_I);
		this.add(fileMenu);

		JMenuItem newItem = new JMenuItem("New", KeyEvent.VK_N);
		newItem.addActionListener(new NewActionListener(frame));

		// creating this from scratch is non-trivial .. see API for details!
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK
				| InputEvent.CTRL_DOWN_MASK));

		JMenuItem openItem = new JMenuItem("Open", KeyEvent.VK_O);
		openItem.addActionListener(new OpenActionListener(frame));
		JMenuItem saveItem = new JMenuItem("Save", KeyEvent.VK_S);
		saveItem.addActionListener(new SaveActionListener(frame));
		JMenuItem closeItem = new JMenuItem("Close", KeyEvent.VK_C);
		closeItem.addActionListener(new CloseActionListener(frame));
		JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		exitItem.addActionListener(new ExitActionListener());
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_DOWN_MASK));

		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
	}
}
