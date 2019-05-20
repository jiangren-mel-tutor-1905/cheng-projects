package fp.topic5.guicomponents;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUIComponentsFrame extends JFrame
{
   public GUIComponentsFrame()
   {
      super("the title");
      setLayout(new FlowLayout());

      // anything that can be local should be :) 
      JButton button = new JButton("Button");
      JCheckBox checkBox = new JCheckBox();
      JLabel label = new JLabel("Label");
      JTextField textField = new JTextField("Text Field");
      JTextArea textArea = new JTextArea("Text Area", 5, 20);

      // you can add the this to refer explicitly to frame but don't need to
      this.add(button);
      add(checkBox);
      add(label);
      JPanel panel = new JPanel();
      panel.add(new JButton("test"));
      panel.setBackground(Color.red);
      add(panel);
      add(textField);
      add(textArea);

      DefaultListModel<String> listModel = new DefaultListModel<String>();
      listModel.addElement("item 1");
      listModel.addElement("item 2");
      listModel.addElement("item 3");
      listModel.addElement("item 4");
      listModel.addElement("item 5");
      listModel.addElement("item 6");
      listModel.addElement("item 7");
      listModel.addElement("item 8");
      listModel.addElement("item 9");
      listModel.addElement("item 10");
      JList<String> list = new JList<String>(listModel);
      JScrollPane scroll = new JScrollPane(list);
      add(scroll);

      JComboBox<String> selector = new JComboBox<String>();
      selector.addItem("Yes");
      selector.addItem("No");
      selector.addItem("Maybe");
      add(selector);

      JRadioButton oftenButton = new JRadioButton("often", true);
      JRadioButton sometimesButton = new JRadioButton("sometimes");
      JRadioButton neverButton = new JRadioButton("never");
      ButtonGroup group = new ButtonGroup();
      group.add(oftenButton);
      group.add(sometimesButton);
      group.add(neverButton);

      add(oftenButton);
      add(sometimesButton);
      add(neverButton);

      setBounds(100, 100, 640, 480);
      // this is generally the last thing we do after frame is configured
      this.setVisible(true);
   }
}
