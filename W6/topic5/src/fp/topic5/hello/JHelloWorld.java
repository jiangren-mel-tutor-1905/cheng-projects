package fp.topic5.hello;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JHelloWorld extends JFrame
{
   public JHelloWorld()
   {
      super("Hello World Frame");
      JLabel greeting = new JLabel("Hello world!");
      // this. is optional .. we are calling the method on the JFrame
      this.setLayout(new FlowLayout());
      add(greeting);
      setBounds(100, 100, 800, 600);
      // if you wanted to start with JFrame maximized
      //setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String args[])
   {
      // GUI code should run on the AWT Event dispatch/UI Thread

      // could use a Java 8 lambda
      // SwingUtilities.invokeLater(() -> new JHelloWorld());

      // but let's keep it explicit so we can see more clearly what is actually happening!
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new JHelloWorld();
         }
      });
   }
}