package fp.topic5.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

// paint onto a swing JPanel 
class BallPanel extends JPanel
{
   // milliseconds (~60FPS)
   private static int INTER_FRAME_DELAY = 1000 / 60;
   // pixels
   private static final int BALL_DIAMETER = 50;
   private static final int X_INC = 2;
   private static final int Y_INC = 2;

   // ball x,y and deltas
   private int x = 0, y = 0, dx = X_INC, dy = Y_INC;

   public BallPanel()
   {
      setBackground(Color.WHITE);

      // add a timer that fires at a particular interval
      new Timer(INTER_FRAME_DELAY, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            // will indirectly call paintComponent() on UI thread
            repaint();
         }
      }).start();
   }

   // override paintComponent not paint in Swing
   // JPanel is double buffered for smooth animation without flickering
   // call in response to repaint() from timer
   @Override
   public void paintComponent(Graphics g)
   {
      // no loop, so the method does not block
      // the timer will handle the animation

      // this will repaint the background (comment to see the difference)
      // set a breakpoint here to here to see the lengthy stack trace from repaint() as well!
      super.paintComponent(g);

      //      if (x < 0)
      //         dx = X_INC;
      //      else if (x > width - diameter)
      //         dx = -X_INC;

      // Caspar: I like using ternary conditions for variable  assignment :)
      // NOTE: we only change dx when a bound/edge is reached
      // Will also respond to resize via getWidth()/getHeight()
      dx = (x < 0) ? X_INC : (x > getWidth() - BALL_DIAMETER) ? -X_INC : dx;
      x += dx;

      dy = (y < 0) ? Y_INC : (y > getHeight() - BALL_DIAMETER) ? -Y_INC : dy;
      y += dy;

      g.setColor(Color.RED);
      g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
   }
}