package liang.chapter10.refactored;

import java.util.Date;

public class Circle extends AbstractGeometricObject
{
	private double radius;

	public Circle()
	{
		this(1.0); // this happens by default
	}

	public Circle(Date date, String color, boolean filled, double radius)
	{
		this(date, color, radius, filled);
	}

	public Circle(Date date, String color, double radius, boolean filled)
	{
		super(date, color, filled);
		this.radius = radius;
	}

	public Circle(double radius)
	{
		// super(); // will be invoked automatically anyway
		this.radius = radius;
	}

	/** Return radius */
	public double getRadius()
	{
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	/** Return diameter */
	public double getDiameter()
	{
		return 2 * radius;
	}

	/* Print the circle info */
	public void printCircle()
	{
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}

	// added by Caspar for polymorphism demo
	@Override
	public String toString()
	{
		// pasted from printCircle();
		return "The circle is created " + getDateCreated() + " and the radius is " + radius;
	}

	/** Return area */
	@Override
	public double getArea()
	{
		return radius * radius * Math.PI;
	}

	/** Return perimeter */
	@Override
	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

}
