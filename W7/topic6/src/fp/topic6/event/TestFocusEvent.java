package fp.topic6.event;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class TestFocusEvent extends SimpleJFrame
{
   public TestFocusEvent()
   {
      setLayout(new FlowLayout());
      // event source
      JButton button1 = new JButton("button 1"), button2 = new JButton("button 2"), button3 = new JButton("button 3");

      // event listener
      ButtonFocusListener listener = new ButtonFocusListener();

      button1.addFocusListener(listener);
      button2.addFocusListener(listener);
      // button3.addFocusListener(listener);

      add(button1);
      add(button2);
      add(button3);
      super.showFrame();
   }

   public static void main(String args[])
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new TestFocusEvent();
         }
      });
   }
}

class ButtonFocusListener implements FocusListener
{
   // event handler methods from FocusListener interface
   @Override
   public void focusGained(FocusEvent event)
   {
      // event parameter is the event object (contains info about event)
      System.out.print(getButtonName(event) + " gained focus");
      checkTemporary(event);
   }

   @Override
   public void focusLost(FocusEvent event)
   {
      System.out.print(getButtonName(event) + " lost focus");
      checkTemporary(event);
   }

   private String getButtonName(FocusEvent event)
   {
      return ((AbstractButton) event.getComponent()).getActionCommand();
   }

   private void checkTemporary(FocusEvent event)
   {
      System.out.println(event.isTemporary() ? ": temporary" : "");
   }
}
