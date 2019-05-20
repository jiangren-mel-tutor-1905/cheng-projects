package fp.topic5.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class QuestionDialogSwing extends JDialog
{
   private boolean yes;

   public boolean yes()
   {
      return yes;
   }

   public QuestionDialogSwing(JFrame parent)
   {
      // set modal (parameter two)
      super(parent, true);
      yes = true;

      QuestionPanel qPanel = new QuestionPanel();
      AnswerPanel aPanel = new AnswerPanel();

      // basic layout using BorderLayout and nested Panels
      setLayout(new BorderLayout());
      add(qPanel, BorderLayout.CENTER);
      add(aPanel, BorderLayout.SOUTH);
      pack();
      // setBounds(100,100,640,480);
   }

   class QuestionPanel extends JPanel
   {
      public QuestionPanel()
      {
         setLayout(new BorderLayout());
         add(new JLabel("Exit Application?", JLabel.CENTER));
      }
   }

   class AnswerPanel extends JPanel
   {

      public AnswerPanel()
      {
         JButton yes_b = new JButton("Yes");
         JButton no_b = new JButton("No");
         setLayout(new FlowLayout(FlowLayout.CENTER));

         // use standard inner class
         yes_b.addActionListener(new YesActionListener());

         // use anonymous inner class
         no_b.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               QuestionDialogSwing.this.yes = false;
               dispose();
            }
         });

         add(yes_b);
         add(no_b);

         yes_b.requestFocus();
      }
   }

   class YesActionListener implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent e)
      {
         QuestionDialogSwing.this.yes = true;
         dispose();
      }
   }
}
