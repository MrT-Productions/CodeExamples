/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * View object responsible for the GUI
 * 
 * @author ttaylor11
 * @author deagle
 */
public class View extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private ControllerInterface controller;
	private ModelInterface model;
	private JTextField endTime;
	private JTextField currentTime;
	private JTextField state;
	private JPanel northLane;
	private JPanel eastLane;
	private JPanel southLane;
	private JPanel westLane;
	private JLabel northSignLabel;
	private JLabel southSignLabel;
	private JLabel eastSignLabel;
	private JLabel westSignLabel;
	private JButton goButton;
	private JButton stepButton;
	private JButton resetButton;

	/**
	 * Constructs the View, gives it access to the controller and registers the
	 * View as an observer of the Model
	 * 
	 * @param controller
	 * @param model
	 */
	public View(ControllerInterface controller, ModelInterface model) {
		this.model = model;
		this.controller = controller;
		model.registerObserver(this);
	}

	/**
	 * Creates and initializes the GUI
	 */
	public void createView() {
		this.setTitle("Traffic Intersection Simulation");
		createFrame();
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	/**
	 * Allows the controller to retrieve the end time from the GUI
	 * 
	 * @return int endTime
	 */
	public int getEndTime() {
		return Integer.parseInt(endTime.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.Observer#update(edu.elon.factory.TrafficFlowSystem)
	 */
	@Override
	public void update(TrafficFlowSystem tfs) {

		state.setText(String.valueOf(tfs.getState()));
		currentTime.setText(String.valueOf(tfs.getTime()));
		updateLane(northLane, tfs.north);
		updateLane(southLane, tfs.south);
		updateLane(eastLane, tfs.east);
		updateLane(westLane, tfs.west);
		northSignLabel.setText(tfs.sm.getNorth().getMessage());
		southSignLabel.setText(tfs.sm.getSouth().getMessage());
		eastSignLabel.setIcon(tfs.sm.getEast().getState().getIcon());
		westSignLabel.setIcon(tfs.sm.getWest().getState().getIcon());
		this.pack();
	}

	private void updateLane(JPanel vehicleLane, VehicleQueue q) {
		vehicleLane.removeAll();
		for (Vehicle v : q.getVehicles()) {
			vehicleLane.add(new JLabel(v.getIcon()));
		}
	}

	private void createFrame() {
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(createLanes()), BorderLayout.NORTH);
		this.add(createFields(), BorderLayout.CENTER);
		this.add(createButtons(), BorderLayout.PAGE_END);
	}

	private JPanel createFields() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel stateLabel = new JLabel("State ");
		state = new JTextField(10);
		state.setEditable(false);

		JLabel currentTimeLabel = new JLabel("Current Time ");
		currentTime = new JTextField(10);
		currentTime.setEditable(false);

		JLabel label = new JLabel("End Time ");
		endTime = new JTextField(10);
		endTime.setText("600");

		panel.add(stateLabel);
		panel.add(state);
		panel.add(currentTimeLabel);
		panel.add(currentTime);
		panel.add(label);
		panel.add(endTime);
		return panel;
	}

	private JPanel createLanes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		northSignLabel = new JLabel("Don't Walk");
		southSignLabel = new JLabel("Don't Walk");
		java.net.URL eastURL = getClass().getResource("greenLightSmall.png");
		if (eastURL != null) {
			ImageIcon icon = new ImageIcon(eastURL);
			eastSignLabel = new JLabel(icon);
		}
		java.net.URL westURL = getClass().getResource("greenLightSmall.png");
		if (westURL != null) {
			ImageIcon icon = new ImageIcon(westURL);
			westSignLabel = new JLabel(icon);
		}

		// North
		JPanel north = new JPanel(new BorderLayout());
		northLane = new JPanel();
		northLane.setLayout(new BoxLayout(northLane, BoxLayout.Y_AXIS));
		north.setBorder(new LineBorder(Color.BLACK, 2));
		JPanel northLabel = new JPanel();
		northLabel.add(northSignLabel);
		north.add(northLane, BorderLayout.NORTH);
		north.add(northLabel, BorderLayout.PAGE_END);

		// East
		JPanel east = new JPanel(new BorderLayout());
		east.setBorder(new LineBorder(Color.BLACK, 2));
		eastLane = new JPanel();
		JPanel eastLabel = new JPanel();
		eastLabel.add(eastSignLabel);
		east.add(eastLane, BorderLayout.EAST);
		east.add(eastLabel, BorderLayout.WEST);

		// West
		JPanel west = new JPanel(new BorderLayout());
		west.setBorder(new LineBorder(Color.BLACK, 2));
		westLane = new JPanel();
		JPanel westLabel = new JPanel();
		westLabel.add(westSignLabel);
		west.add(westLane, BorderLayout.WEST);
		west.add(westLabel, BorderLayout.EAST);

		// South
		JPanel south = new JPanel(new BorderLayout());
		south.setBorder(new LineBorder(Color.BLACK, 2));
		southLane = new JPanel();
		JPanel southLabel = new JPanel();
		southLane.setLayout(new BoxLayout(southLane, BoxLayout.Y_AXIS));
		southLabel.add(southSignLabel);
		south.add(southLabel, BorderLayout.PAGE_START);
		south.add(southLane, BorderLayout.CENTER);
		
		JPanel top = new JPanel();
		top.add(north);
		JPanel mid = new JPanel(new BorderLayout());
		mid.add(west, BorderLayout.LINE_START);
		mid.add(east, BorderLayout.LINE_END);
		JPanel bot = new JPanel();
		bot.add(south);

		panel.add(top);
		panel.add(mid);
		panel.add(bot);
		return panel;
	}

	private JPanel createButtons() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		goButton = new JButton("Go");
		goButton.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.go();
			}

		});
		stepButton = new JButton("Step");
		stepButton.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.step();
			}

		});
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.reset();
			}

		});

		panel.add(goButton);
		panel.add(stepButton);
		panel.add(resetButton);
		return panel;
	}
}
