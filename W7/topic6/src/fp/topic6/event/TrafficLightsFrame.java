package fp.topic6.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// simple abstract class with a single concrete method to avoid code duplication in the layout examples
// Author: Caspar
public class TrafficLightsFrame extends JFrame {
	private int green2yellow = 0;
	private int yellow2red = 0;
	private int red2green = 0;
	private Button redLight = new Button("red");
	private Button yellowLight = new Button("yellow");
	private Button greenLight = new Button("green");

	TrafficLightsFrame(int green2yellow, int yellow2red, int red2green) {
		super();
		this.green2yellow = green2yellow;
		this.yellow2red = yellow2red;
		this.red2green = red2green;

		// set a fixed size (would normally read from config file)
		setBounds(300, 300, 100, 300);
		// so we can close the frame on exit (when 'x' clicked in UI)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(3, 1, 10, 5));

		greenLight.setBackground(Color.GREEN);
		yellowLight.setBackground(Color.YELLOW);
		redLight.setBackground(Color.RED);
		add(this.greenLight);
		add(this.yellowLight);
		add(this.redLight);

		// make it visible
		setVisible(true);

		new Thread() {
			@Override
			public void run() {

				while (true) {
					try {
						turnGreen();
						Thread.sleep(green2yellow * 1000);
						turnYellow();
						Thread.sleep(yellow2red * 1000);
						turnRed();
						Thread.sleep(red2green * 1000);

					} catch (InterruptedException e) {
						e.printStackTrace();
						// continue to sleep
						
					} catch (Exception e) {
						// get up
					}
				}
			}
		}.start();
	}

	// call this method after you have added components to the JFrame
	public void turnGreen() {
		this.greenLight.setVisible(true);
		this.yellowLight.setVisible(false);
		this.redLight.setVisible(false);
	}

	public void turnYellow() {
		this.greenLight.setVisible(false);
		this.yellowLight.setVisible(true);
		this.redLight.setVisible(false);
	}

	public void turnRed() {
		this.greenLight.setVisible(false);
		this.yellowLight.setVisible(false);
		this.redLight.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TrafficLightsFrame(5, 1, 3);
			}
		});
	}
}