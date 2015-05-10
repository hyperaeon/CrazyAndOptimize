package com.optimize.chapter2.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTest {

	public static class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("click");
		}
	}

	public static void main(String[] args) {
		JFrame p = new JFrame();
		JButton btn = new JButton("Click Me");
		btn.addActionListener(new BtnListener());
		p.add(btn);
		p.pack();
		p.setVisible(true);
	}
}
