package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThreadPriority extends AbstractPrintThread
{
	public PrintThreadPriority(int val, int priority)
	{
		super(val);
		setPriority(priority);
	}

	// default is to do nothing
	@Override
	protected void doSomething(int i)
	{
		// might not do as much on unloaded multicore system unless we set
		// processor affinity for javaw.exe
		// to use one core (via task manager in Windows)

		// load up the cpu a bit!
		for (long l = 0; l < 10000000; l++)
			;
	}
}