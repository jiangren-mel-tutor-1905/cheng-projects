package mvc.model;

import java.util.HashMap;

import mvc.view.AppFrame;

// one technique of implementing a system wide registry
// to simplify referencing in MVC 
// (personally I prefer passing parameters to make coupling more explicit!)
public class Registry extends HashMap<String, Object>
{
	// private constructor means only this one instance "singleton" is created
	private static Registry singletonInstance = new Registry();

	// define string constants for the keys
	private static final String MODEL = "Model";
	private static final String VIEW = "View";

	// private constructor means only one instance can be created (i.e.
	// singleton)
	private Registry()
	{
		// add contents to the registry
		Model model = ModelImpl.getSingletonInstance();
		put(MODEL, model);

		AppFrame view = AppFrame.getSingletonInstance();
		put(VIEW, view);
	}

	public static Model getModel()
	{
		return (Model) singletonInstance.get(MODEL);
	}

	public static AppFrame getAppFrame()
	{
		return (AppFrame) singletonInstance.get(VIEW);
	}
}
