package fp.topic4.notgeneric.media;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(
{ "rawtypes", "unchecked" })
class Library
{
	private List resources = new ArrayList();

	public void add(Media x)
	{
		resources.add(x);
	}

	public Object retrieveLast()
	{
		int size = resources.size();
		if (size > 0)
		{
			return resources.get(size - 1);
		}
		return null;
	}
}