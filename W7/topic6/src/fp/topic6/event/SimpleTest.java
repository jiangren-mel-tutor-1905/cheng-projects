package fp.topic6.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class SimpleTest extends SimpleJFrame
{
   public SimpleTest()
   {
      JButton button = new JButton("Press Me"); // Event Source
      button.addActionListener(new ActionListener() // register an action listener
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            System.out.println("Action Event:" + e.toString());
         }
      });
      add(button);
      super.showFrame();
   }

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new SimpleTest();
         }
      });
   }
}
