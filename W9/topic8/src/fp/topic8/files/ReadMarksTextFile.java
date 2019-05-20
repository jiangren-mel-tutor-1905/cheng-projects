package fp.topic8.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//original author unknown, modified by Caspar
public class ReadMarksTextFile
{
	public static void main(String[] args)
	{
		final String SOURCE_FILE = "marks.txt";

		// See https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		// create scanner from File class (can also use either a Reader or InputStream)
		try (Scanner input = new Scanner(new File(SOURCE_FILE)))
		{
			int sum = 0, count = 0;
			while (input.hasNext())
			{
				String sNum = input.next();
				String firstName = input.next();
				int mark = input.nextInt();
				sum += mark;
				count++;
				System.out.printf("%s : %s : %d\n", sNum, firstName, mark);
			}

			if (count > 0)
				System.out.printf("Average mark = %d\n", sum / count);
		}
		// since we have a try block might as well catch here rather than throw to console
		catch (FileNotFoundException fnfe)
		{
			System.err.printf("%s: File not found\n", SOURCE_FILE);
		}
		// general catch all (real app could check individual exceptions by inspecting API)
		catch (Exception e)
		{
			System.err.printf("%s: File read error .. check file format!\n", SOURCE_FILE);
		}
	}
}
