package fp.topic5.tacho;

// Tacho Test by Caspar Ryan
import java.awt.BorderLayout;

import javax.swing.JFrame;

class TachoFrame extends JFrame
{
   public TachoFrame()
   {
      super("Tacho Test");
      setLayout(new BorderLayout());

      TachoBean tachoBean = new TachoBean();
      add(tachoBean, BorderLayout.CENTER);

      setBounds(100, 100, 274, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

      tachoBean.needleSweep(0, 8000);
   }
}
