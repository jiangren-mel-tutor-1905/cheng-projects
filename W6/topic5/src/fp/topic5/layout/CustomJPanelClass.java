package fp.topic5.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

// we use a separate class for the JPnale this time (this is useful for encapsulation and reuse)
public class CustomJPanelClass extends JPanel
{
   public CustomJPanelClass()
   {
      // padding to show preferred size is ignored
      JButton one = new JButton("  1  ");
      JButton two = new JButton("  2  ");
      JButton three = new JButton("  3  ");
      JButton four = new JButton("  4  ");
      JButton five = new JButton("  5  ");
      JButton six = new JButton("  6  ");
      JButton seven = new JButton("  7  ");
      JButton eight = new JButton("  8  ");
      JButton nine = new JButton("  9  ");
      JButton ten = new JButton("this is a long label  ");

      setLayout(new GridLayout(3, 0, 10, 10));
      add(one);
      add(two);
      add(three);
      add(four);
      add(five);
      add(six);
      add(seven);
      add(eight);
      add(nine);
      add(ten);
   }
}