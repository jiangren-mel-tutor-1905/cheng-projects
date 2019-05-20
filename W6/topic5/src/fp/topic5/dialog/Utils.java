package fp.topic5.dialog;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;

public class Utils
{
	// position Dialog in center of Frame
	// NOTE: The Swing JDialog and JFrame extend their AWT counterpart so this utility method 
	// can be used by both AWT and Swing
	public static void setDialogLocation(Frame frame, Dialog dialog)
	{
		Dimension dialogDimension = dialog.getSize();
		Dimension frameDimension = frame.getSize();
		Point frameLocation = frame.getLocation();
		dialog.setLocation(frameLocation.x + ((int) (frameDimension.getWidth() - dialogDimension.getWidth())) / 2,
				frameLocation.y + ((int) (frameDimension.getHeight() - dialogDimension.getHeight())) / 2);
	}
}
