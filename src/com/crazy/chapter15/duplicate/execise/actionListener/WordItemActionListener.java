package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.crazy.chapter15.duplicate.execise.action.Fontdialog;

public class WordItemActionListener implements ActionListener {

	private JFrame f;
	
	public WordItemActionListener(JFrame f) {
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Fontdialog(f, 200, 400);
	}

}
