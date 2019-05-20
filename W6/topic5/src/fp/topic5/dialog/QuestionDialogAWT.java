package fp.topic5.dialog;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionDialogAWT extends Dialog
{
	private boolean yes;

	public boolean yes()
	{
		return yes;
	}

	public QuestionDialogAWT(Frame parent)
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
	}

	class QuestionPanel extends Panel
	{
		public QuestionPanel()
		{
			setLayout(new BorderLayout());
			add(new Label("Exit Application?", Label.CENTER));
		}
	}

	class AnswerPanel extends Panel
	{

		public AnswerPanel()
		{
			Button yes_b = new Button("Yes");
			Button no_b = new Button("No");
			setLayout(new FlowLayout(FlowLayout.CENTER));

			// use standard inner class
			yes_b.addActionListener(new YesActionListener());

			// use anonymous inner class
			no_b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					QuestionDialogAWT.this.yes = false;
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
		public void actionPerformed(ActionEvent e)
		{
			// can refer to "outer" class private attribute 
			QuestionDialogAWT.this.yes = true;
			dispose();
		}
	}
}
