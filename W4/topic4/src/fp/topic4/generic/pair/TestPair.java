package fp.topic4.generic.pair;

import java.util.HashSet;
import java.util.Set;

public class TestPair
{
	public static void main(String args[])
	{
		Pair<String> pair1 = new Pair<String>("10+5", "20+5");
		Pair<String> pair2 = new Pair<String>("15", "25");

		Set<Pair<String>> pairSet = new HashSet<Pair<String>>();
		pairSet.add(pair1);
		pairSet.add(pair2);

		if (pair1.equals(pair2))
			System.out.println("Pairs 1 & 2 Equal");
		else
			System.out.println("Pairs 1 & 2 Not Equal");

		Pair<Integer> pair3 = new Pair<Integer>(10 + 5, 20 + 5);
		Pair<Integer> pair4 = new Pair<Integer>(15, 25);

		if (pair3.equals(pair4))
			System.out.println("Pairs 3 & 4 Equal");
		else
			System.out.println("Pairs 3 & 4 Not Equal");
	}
}
