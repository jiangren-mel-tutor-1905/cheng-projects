package fp.topic8.files;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

//original author unknown, modified by Caspar
public class ReadStudentInfoTextFile
{
	// for something different we will just throw any exceptions to the console
	// especially since we throw our own exception for invalid file format
	public static void main(String[] args) throws IOException
	{
		System.out.println("Name of file to read from : ");
		try (Scanner sc = new Scanner(System.in); Scanner fileSc = new Scanner(new FileReader(sc.nextLine())))
		{
			System.out.println("name\t address\t age");

			while (fileSc.hasNextLine())
			{
				StringTokenizer inReader = new StringTokenizer(fileSc.nextLine(), "\t");
				if (inReader.countTokens() != 3)
					// let the client handle it!
					throw new IOException("Invalid Input Format");
				else
				{
					String name = inReader.nextToken();
					String address = inReader.nextToken();
					int age = Integer.parseInt(inReader.nextToken());
					System.out.printf("%s \t%s \t %d\n", name, address, age);
				}
			}
		}
	}
}
