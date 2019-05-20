package fp.topic6.event.action;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

public class DebugActionListener implements ActionListener
{
   @Override
   public void actionPerformed(ActionEvent e)
   {
      System.out.println("action event in: " + e.getActionCommand());
   }

   // the old AWT List allowed adding an ActionListener but have to do it manually for JList!
   // See https://stackoverflow.com/questions/5609200/adding-an-actionlistener-to-a-jlist
   // NOTE: final params required for the inner classes
   public static void addActionListenerToJList(final JList<?> jList, final ActionListener actionListener)
   {
      // listen for key and mouse events and fire an ActionEvent in response
      jList.addKeyListener(new KeyAdapter()
      {
         public void keyPressed(KeyEvent e)
         {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
               doActionPerformed(e, jList, actionListener);
         }
      });

      jList.addMouseListener(new MouseAdapter()
      {
         public void mouseClicked(MouseEvent e)
         {
            if (e.getClickCount() == 2)
               doActionPerformed(e, jList, actionListener);
         }
      });
   }

   // make a separate private method since we have to call it for both Key and MouseEvent
   private static void doActionPerformed(AWTEvent e, JList<?> jList, ActionListener actionListener)
   {
      actionListener.actionPerformed(new ActionEvent(e.getSource(), e.getID(), jList.getSelectedValue().toString()));
   }
}