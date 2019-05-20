package fp.topic8.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//original author unknown, modified by Caspar
public class BinaryToTextFile
{
   public static void main(String[] args)
   {
      final String DEST_FILE = "dest.txt";

      // See https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
      // open destination file (could have used a PrintWriter but use a PrintStream instead this time)
      try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(DEST_FILE)))
      {
         // PrintStream and PrintWriter has printf method :)
         printWriter.printf("%b\n%d\n%.2f\n", true, 17, 123.45);
      }
      // since we have a try block might as well catch here rather than throw to console
      catch (FileNotFoundException fnfe)
      {
         System.err.printf("%s: File creation error\n", DEST_FILE);
      }
   }
}
