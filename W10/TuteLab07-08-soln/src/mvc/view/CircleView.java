package mvc.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import mvc.controller.CircleControllerAssignmentStyle;
import mvc.model.Model;
import mvc.model.Registry;
import mvc.view.factory.ImageIconFactory;

@SuppressWarnings("deprecation")
public class CircleView extends JLabel implements Observer
{
   // one controller for all instances of the views
   // this favors efficiency over readability since behaviour is the same for all
   //private static CircleController circleController = new CircleController();

   private Model model;

   private int viewNumber;

   // used by the controller to identify the view
   public int getViewNumber()
   {
      return viewNumber;
   }

   public CircleView(int i)
   {
      model = Registry.getModel();
      viewNumber = i;

      // center the icon in the label
      setHorizontalAlignment(JLabel.CENTER);
      setVerticalAlignment(JLabel.CENTER);

      // get starting color from the model
      setIcon(ImageIconFactory.getImageIcon(model.getColor(i)));

      // register controller with this view (two different approaches .. uncomment one only)
      //addMouseListener(circleController);
      addMouseListener(new CircleControllerAssignmentStyle(i, Registry.getAppFrame(), model));

      // add this button (View in MVC) as an observer of the model
      model.addObserver(this);
   }

   // this is the Observer method called from the model
   // arg contains the 'moused' view number
   @Override
   public void update(Observable o, Object arg)
   {
      // cast is necessary since Observable doesn't use generics
      Model model = (Model) o;

      // this checks if the notification is relevant
      // i.e. only the button (view) that was just interacted with should respond
      // COMMENT FOLLOWING LINE for a completely different solution where all views respond!
      if (getViewNumber() == (int) arg)
      {
         // change icon Color by retrieving color data from model
         // and using factory to retrieve the correct ImageIcon
         setIcon(ImageIconFactory.getImageIcon(model.getColor((int) arg)));
      }
   }

}
