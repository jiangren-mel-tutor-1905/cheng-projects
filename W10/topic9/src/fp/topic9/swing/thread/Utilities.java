package fp.topic9.swing.thread;

public class Utilities
{
	// put our utility method in a separate class for cohesion
	public static void wait5secs()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException ex)
		{
		}
	}
}
