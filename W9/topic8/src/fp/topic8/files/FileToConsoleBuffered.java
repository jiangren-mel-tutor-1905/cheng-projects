package fp.topic8.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//original author unknown, modified by Caspar
public class FileToConsoleBuffered
{
	public static void main(String[] args) throws IOException // from reader.readLine()
	{
		final String SOURCE_FILE = "source.txt";

		// See https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		// use BufferedReader instead of Scanner
		try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE_FILE)))
		{
			String nextLine;
			while ((nextLine = reader.readLine()) != null)
				System.out.println(nextLine);
		}
		// since we have a try block might as well catch here rather than throw to console
		catch (FileNotFoundException fnfe)
		{
			System.err.printf("%s: File not found\n", SOURCE_FILE);
		}
	}
}
