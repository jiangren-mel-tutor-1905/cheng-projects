package fp.topic6.event.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fp.topic6.event.TrafficLightsFrame;
import fp.topic6.event.TrafficLightsModel;

public class StartButtonListener extends MouseAdapter {
	private TrafficLightsFrame view = null;
	private TrafficLightsModel model = null;
	public StartButtonListener(TrafficLightsFrame frame, TrafficLightsModel model) {
		super();
		this.view = frame;
		this.model = model;
	}
	@Override
    public void mouseReleased(MouseEvent e) {
		this.view.start();
	}

}
