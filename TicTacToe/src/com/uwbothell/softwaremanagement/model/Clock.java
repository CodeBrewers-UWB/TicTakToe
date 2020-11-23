package com.uwbothell.softwaremanagement.model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.uwbothell.softwaremanagement.controller.GameController;


public class Clock implements Runnable{
	private JLabel clockLabel;
	private int seconds;
	private Thread thread = null;
	private boolean normalRun;
	private GameController controller;
	
	public Clock(GameController controller) {
		this.clockLabel = new JLabel();
		normalRun = true;
		this.controller = controller;
		startClock();
	}
	
	public void setClockLabel(int seconds) {
		clockLabel.setText("Time : " + seconds);
	}
	
	public JLabel getClockLabel() {
		return clockLabel;
	}
	
	public void resetClock() {
		normalRun = true;
		seconds = 30;
	}
	
	public void stopClock() {
		normalRun = false;
		seconds = 0;
	}

	private void startClock() {
		resetClock();		
		setClockLabel(seconds);
		thread = new Thread(this);	
		thread.start();
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				setClockLabel(seconds);
				thread.sleep(1000);
				if(seconds > 0) {
					seconds--;
					setClockLabel(seconds);
					if(seconds == 0 && normalRun) {
						controller.timesUp();
					}
				}
			}
		}
		catch(Exception e) {}
		
	}
}
