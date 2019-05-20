package fp.topic5.tacho;

import javax.swing.SwingUtilities;

//Tacho Test by Caspar Ryan
public class TestTacho
{
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new TachoFrame();
         }
      });
   }
}
