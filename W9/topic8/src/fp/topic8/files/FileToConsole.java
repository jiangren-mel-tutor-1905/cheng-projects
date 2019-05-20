package fp.topic8.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//original author unknown, modified by Caspar
public class FileToConsole
{
   public static void main(String[] args)
   {
      final String SOURCE_FILE = "source.txt";

      // See https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
      // create scanner from file stream (can use either a Reader or InputStream)
      try (Scanner sc = new Scanner(//new File(SOURCE_FILE)))
         // an InputStream just just like System.in!
         new FileInputStream(SOURCE_FILE)))
      {
         while (sc.hasNextLine())
            System.out.println(sc.nextLine());
      }
      // since we have a try block might as well catch here rather than throw to console
      catch (FileNotFoundException fnfe)
      {
         System.err.printf("%s: File not found\n", SOURCE_FILE);
      }
      catch (Throwable t)
      {
         System.err.printf("general error");
         System.exit(-1);
      }
   }
}
