package fp.topic8.files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//original author unknown, modified by Caspar
public class WriteStudentInfoTextFile
{
	public static void main(String[] args)
	{
		System.out.println("Enter the name of the file : ");

		try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(new FileWriter(sc.nextLine())))
		{
			do
			{
				System.out.println("Enter name : ");
				String name = sc.nextLine();
				System.out.println("Enter address:");
				String address = sc.nextLine();
				System.out.println("Enter age : ");
				int age = sc.nextInt();
				sc.nextLine(); // clear trailing newline from nextInt()
				// write input data to file
				pw.printf("%s\t%s\t%d\n", name, address, age);
				System.out.println("Continue  Y/N ?");
			}
			// can throw exception can you fix it?
			while (Character.toUpperCase(sc.nextLine().charAt(0)) == 'Y');
		}
		// Note that FileWriter throws a different exception to the previous 
		// FileInputStream/FileInputStream examples
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
