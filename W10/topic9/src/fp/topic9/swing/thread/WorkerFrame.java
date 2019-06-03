package fp.topic9.swing.thread;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

class WorkerFrame extends JFrame
{
   private JProgressBar progressBar = new JProgressBar(0, 100);
   private JTextArea textArea = new JTextArea();

   public WorkerFrame()
   {
      setLayout(new BorderLayout());
      add(progressBar, BorderLayout.SOUTH);
      add(textArea, BorderLayout.CENTER);

      JButton swingWorkerButton = new JButton("Run Task");
      add(swingWorkerButton, BorderLayout.NORTH);
      swingWorkerButton.addActionListener(new WorkerActionListener(this));

      setBounds(250, 250, 600, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public void append(String s)
   {
      textArea.append(s);
   }

   public void setProgress(Integer i)
   {
      progressBar.setValue(i);
      // progressBar.revalidate();
   }
}
