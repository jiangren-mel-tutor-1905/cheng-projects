package fp.topic5.graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// SADI Topic 5 graphics example
//
// Original author unknown
// Refactored by Caspar
//
public class BouncingBall extends JFrame
{
   public BouncingBall()
   {
      setLayout(new BorderLayout());
      add(new BallPanel(), BorderLayout.CENTER);
      setBounds(100, 100, 800, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String args[])
   {
      // GUI code should run on the AWT Event dispatch/UI Thread
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new BouncingBall();
         }
      });
   }
}
