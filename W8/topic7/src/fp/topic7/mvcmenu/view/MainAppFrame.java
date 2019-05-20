package fp.topic7.mvcmenu.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fp.topic7.mvcmenu.model.MenuModel;

public class MainAppFrame extends JFrame
{
   private JTextArea text;

   private JScrollPane scroll;

   private boolean fileOpen = false;

   private MenuModel model = new MenuModel();

   public MainAppFrame()
   {
      setBounds(250, 250, 640, 480);

      // set the menu created in another class
      setJMenuBar(new MainMenuBar(this));

      text = new JTextArea(20, 50);
      text.setFont(new Font("Courier New", Font.PLAIN, 12));
      text.setText(model.getData());
      scroll = new JScrollPane(text);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public void displayNewDocument()
   {
      if (!fileOpen)
      {
         fileOpen = true;
         // get data from model for document
         text.setText(model.getData());
         add(scroll);
         // since we added a component need to relayout
         // but required with jdk1.8.0_121
         revalidate();
         // shouldn't really need this since revalidate() should redraw correctly!
         // possibly an issue with the scrollpane heavyweight behaviour?
         repaint();
      }
   }

   public void closeDocument()
   {
      fileOpen = false;
      // save data to model from document
      // do it here rather than model since the frame has a reference to the data to store 
      model.setData(text.getText());
      remove(scroll);
      // repaint the background
      revalidate();
      repaint();
   }
}
