package fp.topic4.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SimpleTest
{
	public static void main(String args[])
	{
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();

		// add elements to list
		list.add(new String("4"));
		list.add(new String("two"));
		list.add("three");

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).charAt(0));

		// traverse using iterator
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			String next = iter.next();
			System.out.println(next);
		}

		// generic method call
		Collections.<String> copy(list, list2);

		// traverse using Java 5 for each loop
		for (String next : list2)
			System.out.println(next);
	}
}
