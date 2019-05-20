package fp.topic7.mvcmenu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.topic7.mvcmenu.view.MainAppFrame;

public class NewActionListener implements ActionListener
{
   private MainAppFrame frame;

   public NewActionListener(MainAppFrame frame)
   {
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      frame.displayNewDocument();
   }
}
