package fp.topic8.serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable
{
   private String sNum;
   // uncomment to test transient keyword
   // private transient String sNum;

   private String name;
   private Committee com = null;
   private List<String> courses = new ArrayList<String>();

   public Student(String name, String sNum)
   {
      this.name = name;
      this.sNum = sNum;
   }

   public void add(String subject)
   {
      courses.add(subject);
   }

   public void set(Committee c)
   {
      com = c;
      com.increment();
   }

   // refactored by Caspar to use toString() and StringBuilder
   // since we need to construct the String iteratively
   @Override
   public String toString()
   {
      // See API for thread safe equivalent java.lang.StringBuffer
      StringBuilder sb = new StringBuilder();

      sb.append("Name: ").append(name).append(", SNum = ").append(sNum).append("\n Courses:\n");

      for (String course : courses)
         sb.append(" ").append(course).append("\n");

      if (com != null)
         sb.append(com.toString());

      return sb.toString();
   }
}