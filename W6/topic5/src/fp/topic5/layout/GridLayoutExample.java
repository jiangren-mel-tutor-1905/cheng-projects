package fp.topic5.layout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.SwingUtilities;

public class GridLayoutExample extends SimpleJFrame
{
   public GridLayoutExample()
   {
      // using a separate class for our JPanel this time
      Container buttonPanel = new CustomJPanelClass();
      // and we wrap it in another custom class to decorate it with a custom border!
      Container border = new TenPixelBorder(buttonPanel);
      // add the custom JPanel to the JFrame
      setLayout(new BorderLayout());
      add(border, BorderLayout.CENTER);
      // call super to show the frame
      super.showFrame();
   }

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new GridLayoutExample();
         }
      });
   }
}
