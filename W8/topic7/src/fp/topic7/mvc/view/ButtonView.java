package fp.topic7.mvc.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import fp.topic7.mvc.controller.ButtonController2;
import fp.topic7.mvc.model.Model;
import fp.topic7.mvc.model.ModelImpl;

@SuppressWarnings("deprecation")
public class ButtonView extends JButton implements Observer
{
   // one controller for all instances of the views
   //private static ButtonController buttonController = new ButtonController();

   private int viewNumber;

   // used by the controller to identify the view
   public int getViewNumber()
   {
      return viewNumber;
   }

   public ButtonView(int i)
   {
      // set the label of the button
      super(Integer.toString(i));
      Model model = ModelImpl.getSingletonInstance(); // Registry.getModel();
      viewNumber = i;
      // store some data related to this view in the model (the button label)
      model.setData(i, String.valueOf(i));

      // register controller with this view
      //addMouseListener(buttonController);
      // I have used two different referencing approaches so uncomment one only
      addMouseListener(new ButtonController2(model, this));

      // add this button (View in MVC) as an observer of the model
      model.addObserver(this);
   }

   // this is the Observer method called from the model
   // arg contains the view number
   @Override
   public void update(Observable o, Object arg)
   {
      // cast necessary since Observable doesn't use generics
      Model model = (Model) o;

      // this checks if the notification is relevant
      // i.e. only the button (view) that was just interacted with should respond
      // Java 7 and above allows casting an Object to a primitive int
      if (getViewNumber() == (int) arg)
      {
         // change mouse text to notify user of event (and retrieve new data
         // from model)
         setText(model.getData(getViewNumber()));
      }
   }
}
