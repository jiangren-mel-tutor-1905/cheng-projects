package sadi.tutelab00.part2;

public class Course
{
	private static final int MAX_STUDENTS = 100;

	// attributes
	private String id;
	private String name;

	// could have put the courses in student instead but specified enroll method implies it is here
	// could also have stored studentID as a String[] instead but this is more flexible
	private Student[] students = new Student[MAX_STUDENTS];
	private int numStudents;

	public Course(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	// Could have stored ID only but Student gives more flexibility
	public boolean enrol(Student student)
	{
		// don't over enroll and exceed array bounds!
		if (numStudents < MAX_STUDENTS)
		{
			students[numStudents++] = student;
			return true;
		}

		return false;
	}

	@Override
	// this returns the course details plus enrollment details
	public String toString()
	{
		// use string buffer since we need to build a string from a loop and don't want to create lots of String objects!
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("CourseID: %s, Course Name: %s", id, name));
		buffer.append('\n');
		// note that we use Student.toString() here via students[i]
		for (int i = 0; i < numStudents; i++)
			buffer.append(String.format("Enrollment: %d, student: %s\n", i+1,
					students[i]));

		return buffer.toString();
	}
}
