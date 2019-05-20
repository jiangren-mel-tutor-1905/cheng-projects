package liang.chapter9;

// Note from Caspar
// This technique is for demonstration only and should be avoided!
public class TestPolymorphismCasting {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two objects
    Object object1 = new Circle(1);
    Object object2 = new Rectangle(1, 1);

    // Display circle and rectangle
    displayObject(object1);
    displayObject(object2);
  }

//Note from Caspar
//The correct technique is to place Circle specific behaviour in Circle class and
//Rectangle specific behaviour in Rectangle class
  /** A method for displaying an object */
  public static void displayObject(Object object) {
    if (object instanceof Circle) {
      System.out.println("The circle area is " +
        ((Circle)object).getArea());
      System.out.println("The circle diameter is " +
        ((Circle)object).getDiameter());
    }
    else if (object instanceof Rectangle) {
      System.out.println("The rectangle area is " +
        ((Rectangle)object).getArea());
    }
  }
}
