package fp.topic7.mvcmenu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import fp.topic7.mvcmenu.view.MainAppFrame;

public class SaveActionListener implements ActionListener
{
   private MainAppFrame frame;

   public SaveActionListener(MainAppFrame frame)
   {
      this.frame = frame;
   }

   // this code might be better done by the frame or another class
   @Override
   public void actionPerformed(ActionEvent e)
   {
      JFileChooser fileChooser = new JFileChooser();
      if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION)
         JOptionPane.showMessageDialog(frame, "Save file selected was " + fileChooser.getSelectedFile().getPath());
   }
}
