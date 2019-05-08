package sadi.tutelab00.part2;

//TuteLab 00 solution by Caspar 2018
public class EnrolmentSystem
{
   public static void main(String[] args)
   {
      Student student1 = new Student("s123", "Jane Doe");
      Student student2 = new Student("s456", "John Doe");

      Course p1 = new Course("COSC1073", "Programming 1");
      Course sadi = new Course("COSC2391", "Software Architecture Design and Implementation");

      p1.enrol(student1);
      p1.enrol(student2);

      System.out.println(student1);
      System.out.println(student2);
      System.out.println();
      System.out.println(p1);
      System.out.println(sadi);
   }
}
