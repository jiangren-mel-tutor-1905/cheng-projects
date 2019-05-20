package fp.topic8.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//original author unknown, modified by Caspar
public class FileToFile
{
   public static void main(String[] args)
   {
      // set to "" if not windows
      final String DRIVE = "C:";
      // use File.separator constant for cross platform compatibility
      // C:\Users\caspar\Documents\SharedDocs\eclipse-workspaces\FP\Topic8\
      // could just hard code C:\\Users\\caspar\\Documents\\SharedDocs\\eclipse-workspaces\\FP\\Topic8\\
      // or even C:/Users/caspar/Documents/SharedDocs/eclipse-workspaces/FP/Topic8/
      final String PATH = String.format(
         "%s%sUsers%scaspar%sDocuments%sSharedDocs%seclipse-workspaces%sFP%sTopic8%s", DRIVE,
         File.separator, File.separator, File.separator, File.separator, File.separator,
         File.separator, File.separator, File.separator);

      final String SOURCE_FILE = String.format("%s%s", PATH, "source.txt");
      final String DEST_FILE = String.format("%s%s", PATH, "dest.txt");

      // See https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
      // open source and destination
      try (Scanner sc = new Scanner(new FileInputStream(SOURCE_FILE));
         PrintStream ps = new PrintStream(new FileOutputStream(DEST_FILE)))
      {
         // loop until end of source file
         while (sc.hasNextLine())
            ps.println(sc.nextLine()); // copy line to destination file
      }
      // since we have a try block might as well catch here rather than throw to console
      catch (FileNotFoundException fnfe)
      {
         System.err.printf("%s: File not found\n", SOURCE_FILE);
      }
   }
}
