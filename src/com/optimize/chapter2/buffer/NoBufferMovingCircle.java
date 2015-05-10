package com.optimize.chapter2.buffer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JApplet;

public class NoBufferMovingCircle extends JApplet implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image = null;
	Thread thread;
	int x = 5;
	int move = 1;
	
	public void init() {
		image = createImage(230, 160);
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				x += move;
				if (x > 105 || x < 5) {
					move *= -1;
				}
				repaint();
				Thread.sleep(10);
			}
		} catch (Exception e) {
			
		}
	}

	public void drawCircle(Graphics gc) {
		Graphics2D g = (Graphics2D) gc;
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 200, 100);
		g.setColor(Color.red);
		g.fillOval(x, 5, 90, 90);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 100);
		drawCircle(g);
	}
}
