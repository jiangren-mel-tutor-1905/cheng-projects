package fp.topic5.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

// note we are extending an abstract class for some 'boilerplate' code
public class FlowLayoutExample extends SimpleJFrame
{
   public FlowLayoutExample()
   {
      // create some components (using local scope for encapsulation)
      JButton one = new JButton("  1  "), two = new JButton("  2  "), three = new JButton("3"), four = new JButton(
         "  4 has a longer label "), five = new JButton("  5  "), six = new JButton("  6  ");
      // set the layout of this JFrame
      setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      // add the components
      this.add(one);
      add(two);
      add(three);
      add(four);
      add(five);
      add(six);
      // make the frame visible
      super.showFrame();
   }

   // make this example executable
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new FlowLayoutExample();
         }
      });
   }
}
