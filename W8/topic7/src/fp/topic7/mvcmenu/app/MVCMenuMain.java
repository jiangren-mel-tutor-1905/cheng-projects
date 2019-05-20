package fp.topic7.mvcmenu.app;

import javax.swing.SwingUtilities;

import fp.topic7.mvcmenu.view.MainAppFrame;

// refactored example of fp.topic5.menu by Caspar (uses MVC and increases cohesion)
public class MVCMenuMain
{
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new MainAppFrame();
         }
      });
   }
}
