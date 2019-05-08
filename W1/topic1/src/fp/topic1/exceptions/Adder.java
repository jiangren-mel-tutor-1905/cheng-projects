package fp.topic1.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Adder
{
	public static void main(String[] args)
	{
		int n1 = UserReader.getInt("Enter a number: ");
		int n2 = UserReader.getInt("Enter another number: ");

		System.out.println("The sum is " + (n1 + n2));
	}
}

class UserReader
{
	public static int getInt(String prompt)
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		int number = 0;
		boolean valid = false;

		while (!valid)
		{
			System.out.print(prompt);

			try
			{
				number = Integer.parseInt(stdin.readLine());
				valid = true;
			} catch (NumberFormatException exception)
			{
				System.err.println("Invalid input." + "Try again.");
			} catch (IOException exception)
			{
				System.err.println("Input problem." + "Terminating.");
				System.exit(0);
			}

		}// end while loop

		return number;
	}
}
