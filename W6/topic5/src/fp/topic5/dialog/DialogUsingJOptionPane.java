// Basic Swing Frame/Dialog behaviour
// Compare with TestQuestionAWT
// Written by Caspar Ryan
package fp.topic5.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class DialogUsingJOptionPane
{
   public static void main(String args[])
   {
      // create a frame and make it visible
      final JFrame appFrame = new JFrame("JOptionPane Dialog (Swing)");
      appFrame.setBounds(100, 100, 800, 600);
      appFrame.setVisible(true);
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Swing provides basic dialogs via JOptionPane class
      // so no need to write the custom QuestionDialog as is necessary in AWT
      // although it is still converted to Swing in the QuestionDialogSwing class
      // to show similarity between basic AWT/Swing components

      System.out.println(JOptionPane.showInputDialog(appFrame, "Enter Data", "Dialog Title",
         JOptionPane.QUESTION_MESSAGE));

      int returnValue = JOptionPane.showConfirmDialog(appFrame, "Exit Application?", "Confirm Dialog",
         JOptionPane.YES_NO_OPTION);
      System.out.println(returnValue == JOptionPane.YES_OPTION ? "YES" : "NO");
      if (returnValue == JOptionPane.YES_OPTION)
         System.exit(0);
   }
}
