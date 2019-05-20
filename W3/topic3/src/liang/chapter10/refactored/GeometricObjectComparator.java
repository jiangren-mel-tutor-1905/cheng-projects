package liang.chapter10.refactored;

import java.util.Comparator;

public class GeometricObjectComparator implements Comparator<AbstractGeometricObject>
{
	@Override
	public int compare(AbstractGeometricObject o1, AbstractGeometricObject o2)
	{
		double area1 = o1.getArea();
		double area2 = o2.getArea();

		if (area1 < area2)
			return -1;
		else if (area1 == area2)
			return 0;
		else
			return 1;
	}
}
