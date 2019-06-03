package mvc.view.factory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import mvc.model.Model.Color;

// Factory class with a single static method to retrieve an ImageIcon for a given color
// efficient implementation only creates Icons once and only when needed
public class ImageIconFactory
{
	// file path can be configured, NOTE: uses platform neutral separator
	private static final String FILE_PATH = String.format("images%s", File.separator);

	private static final String[] FILE_STRINGS = new String[]
	{ "circle_blue.png", "circle_green.png", "circle_orange.png", "circle_red.png", "circle_yellow.png" };

	// array of ImageIcons (only need to create once then reuse)
	private static Map<Color, ImageIcon> imageIconMap;

	public static ImageIcon getImageIcon(Color color)
	{
		// lazy instantiation and initialisation (on demand)
		if (imageIconMap == null)
			createImageIcons();

		return imageIconMap.get(color);
	}

	private static void createImageIcons()
	{
		// lazy instantiation and initialisation (on demand)
		imageIconMap = new HashMap<Color, ImageIcon>();

		// we can loop through an enum type (using .values() to return an array)
		// .ordinal() gets the index in the enum so we can map it to the filename strings
		for (Color color : Color.values())
			imageIconMap.put(color, new ImageIcon(getFullPath(color)));
	}

	// do an extra check to add trailing path if necessary
	private static String getFullPath(Color color)
	{
		return String.format("%s%s%s", FILE_PATH, FILE_PATH.endsWith(File.separator) ? "" : File.separator,
				FILE_STRINGS[color.ordinal()]);
	}
}
