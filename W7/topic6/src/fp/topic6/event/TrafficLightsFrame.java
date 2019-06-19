package fp.topic6.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fp.topic6.event.action.StartButtonListener;

// simple abstract class with a single concrete method to avoid code duplication in the layout examples
// Author: Caspar
public class TrafficLightsFrame extends JFrame {
	private Button redLight = new Button("red");
	private Button yellowLight = new Button("yellow");
	private Button greenLight = new Button("green");
	private TextField inputTime = new TextField(); 
	private Button startButton = new Button("start");
	private Label time = new Label();
	private TrafficLightsModel model = new TrafficLightsModel();
	private int timer = 0;

	public void update() {
		int timeLeft = 0;
		if (timer >= model.green2yellow + model.yellow2red + model.red2green) {
			turnGreen();
			timer = 0;
			return;
		} else if (timer >= model.green2yellow + model.yellow2red) {
			turnRed();
			timeLeft = model.green2yellow + model.yellow2red + model.red2green - timer;
		} else if (timer >= model.green2yellow) {
			turnYellow();
//			System.out.println("turn on the yellow light");
			timeLeft = model.green2yellow + model.yellow2red - timer;
		} else {
			timeLeft = model.green2yellow - timer;
		}
		
		this.time.setText(timeLeft + " s left");
		
		timer++;
	}
	
	public void start() {
		turnGreen();

		new Thread() {
			@Override
			public void run() {

				while (true) {
					try {
						update();
						sleep(1000);
//						
//						turnGreen();
//						time.setText(green2yellow + " s");
//						Thread.sleep(green2yellow * 1000);
//						turnYellow();
//						time.setText(yellow2red + " s");
//						Thread.sleep(yellow2red * 1000);
//						turnRed();
//						time.setText(red2green + " s");
//						Thread.sleep(red2green * 1000);

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

	TrafficLightsFrame(int green2yellow, int yellow2red, int red2green) {
		super();
		model.green2yellow = green2yellow;
		model.yellow2red = yellow2red;
		model.red2green = red2green;

		// set a fixed size (would normally read from config file)
		setBounds(300, 300, 20, 300);
		// so we can close the frame on exit (when 'x' clicked in UI)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(6, 1, 10, 5));

		greenLight.setBackground(Color.GREEN);
		yellowLight.setBackground(Color.YELLOW);
		redLight.setBackground(Color.RED);
		add(this.time);
		add(this.greenLight);
		add(this.yellowLight);
		add(this.redLight);
		this.inputTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int t = Integer.parseInt(inputTime.getText());
					model.green2yellow = t;
					model.yellow2red = t;
					model.red2green = t;
				} catch (NumberFormatException exception) {
					
				}
				
			}
		});
		add(this.inputTime);
		this.startButton.addMouseListener(new StartButtonListener(this, this.model));
		add(this.startButton);

		// make it visible
		setVisible(true);

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
				new TrafficLightsFrame(3, 3, 3);
//				new TrafficLightsFrame(1, 1, 3);
			}
		});
	}
}