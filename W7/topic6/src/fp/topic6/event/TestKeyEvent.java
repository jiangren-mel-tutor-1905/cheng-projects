package fp.topic6.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestKeyEvent extends SimpleJFrame
{
   public TestKeyEvent()
   {
      setLayout(new FlowLayout());
      JTextField textField = new JTextField(10);
      textField.addKeyListener(new TextfieldListener());
      textField.addActionListener(new TextFieldActionListener());
      add(textField);
      super.showFrame();
   }

   public static void main(String args[])
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new TestKeyEvent();
         }
      });
   }
}

class TextfieldListener implements KeyListener
{
   @Override
   public void keyPressed(KeyEvent e)
   {
      System.out.println("KEY_PRESSED:  ");
      report(e);
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      System.out.println("KEY_RELEASED:  ");
      report(e);
   }

   @Override
   public void keyTyped(KeyEvent e)
   {
      System.out.println("KEY_TYPED:  ");
      report(e);
   }

   @SuppressWarnings("deprecation")
   private void report(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      char keyChar = e.getKeyChar();

      // use bit masking to check for modifier key
      // see API docs for difference between getModifiers() and newer getModifiersEx()
      if ((e.getModifiers() & InputEvent.ALT_MASK) != 0)
         System.out.println("** Modifier bit masking shows ALT");
      if ((e.getModifiersEx() & InputEvent.ALT_DOWN_MASK) != 0)
         System.out.println("** ModifierEx bit masking shows ALT_DOWN");

      // these two methods are static (getModifiers inherited from InputEvent)
      String mods = KeyEvent.getKeyModifiersText(e.getModifiers());
      String txt = KeyEvent.getKeyText(keyCode);

      if (keyCode != KeyEvent.VK_UNDEFINED)
         System.out.println("Code:  " + keyCode);

      if (keyChar != KeyEvent.CHAR_UNDEFINED)
         System.out.println("Char:  " + keyChar);

      if (keyChar >= '0' && keyChar <= '9')
      {
         e.consume();
         System.out.println("Consuming (ignoring) numeric characters");
      }

      System.out.println("Modifiers:  " + mods);
      System.out.println("Text:  " + txt);

      if (e.isActionKey())
         System.out.println("ACTION");

      System.out.println();
   }
}

class TextFieldActionListener implements ActionListener
{
   @Override
   public void actionPerformed(ActionEvent e)
   {
      System.out.println("ActionPerformed");
   }
}
