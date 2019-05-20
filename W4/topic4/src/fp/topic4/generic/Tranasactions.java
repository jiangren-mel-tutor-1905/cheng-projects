package fp.topic4.generic;

import java.util.ArrayList;
import java.util.List;

class Transactions<T1, T2>
{
	private List<T1> owners = new ArrayList<T1>();
	private List<T2> items = new ArrayList<T2>();
	private List<Integer> nums = new ArrayList<Integer>();
	private String title;

	public Transactions(String title)
	{
		this.title = title;
	}

	public void add(T1 owner, T2 item, int num)
	{
		owners.add(owner);
		items.add(item);
		nums.add(num);
	}

	public void list()
	{
		System.out.println(title);
		for (int i = 0; i < owners.size(); i++)
			System.out.println(owners.get(i) + "\t" + items.get(i) + "\t" + nums.get(i));
	}
}
