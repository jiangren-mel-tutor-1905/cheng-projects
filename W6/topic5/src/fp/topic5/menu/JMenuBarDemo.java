package fp.topic5.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import fp.topic5.layout.SimpleJFrame;

// Demonstrate basic menu functionality
// A more cohesive design for this example is available in Topic 7
// variable scope refactored by Caspar for better encapsulation
class JMenuBarDemo extends SimpleJFrame
{
   // these are the only two that are non final and need to be instance variables
   private JTextArea text;
   private boolean fileOpen = false;

   public JMenuBarDemo()
   {
      setBackground(Color.gray);

      // create Menu Bar
      JMenuBar menubar = new JMenuBar();
      // create Menu
      JMenu fileMenu = new JMenu("File");

      fileMenu.setMnemonic(KeyEvent.VK_F);
      menubar.add(fileMenu);

      // create Menu Items
      JMenuItem newItem = new JMenuItem("New", KeyEvent.VK_N);

      // creating this from scratch is non-trivial .. see API for details!
      // NOTE: getMenuShortcutKeyMaskEx() will give us CRTL on Windows and CMD on Mac
      newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK
         | Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

      JMenuItem openItem = new JMenuItem("Open", KeyEvent.VK_O);
      JMenuItem saveItem = new JMenuItem("Save", KeyEvent.VK_S);
      JMenuItem closeItem = new JMenuItem("Close", KeyEvent.VK_C);
      JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
      exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_DOWN_MASK));

      final JFileChooser fileSelection = new JFileChooser(new File("H:\\"));
      text = new JTextArea(20, 50);
      text.setFont(new Font("Courier New", Font.PLAIN, 12));

      final JScrollPane scroll = new JScrollPane(text);

      // add listeners to Menu Items
      newItem.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            if (!fileOpen)
            {
               fileOpen = true;
               add(scroll);
               revalidate();
            }
            else
               text.setText("");
         }
      });

      openItem.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            if (fileSelection.showOpenDialog(JMenuBarDemo.this) == JFileChooser.APPROVE_OPTION)
               JOptionPane.showMessageDialog(JMenuBarDemo.this, "Open file selected was "
                  + fileSelection.getSelectedFile().getPath());
         }
      });

      saveItem.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            if (fileSelection.showSaveDialog(JMenuBarDemo.this) == JFileChooser.APPROVE_OPTION)
               JOptionPane.showMessageDialog(JMenuBarDemo.this, "Save file selected was "
                  + fileSelection.getSelectedFile().getPath());
         }
      });

      closeItem.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            fileOpen = false;
            text.setText("");
            remove(scroll);
            repaint();
         }
      });

      exitItem.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      });

      // add MenuItems to the Menu
      fileMenu.add(newItem);
      fileMenu.add(openItem);
      fileMenu.add(saveItem);
      fileMenu.add(closeItem);
      fileMenu.addSeparator();
      fileMenu.add(exitItem);

      // and the Menu to the MenuBar
      menubar.add(fileMenu);

      // attach the MenuBar to the Frame
      this.setJMenuBar(menubar);
      super.showFrame();
   }

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new JMenuBarDemo();
         }
      });
   }
}
