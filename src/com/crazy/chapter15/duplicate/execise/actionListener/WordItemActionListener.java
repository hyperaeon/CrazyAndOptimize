package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.crazy.chapter15.duplicate.execise.action.Fontdialog;

public class WordItemActionListener implements ActionListener {

	private JFrame f;
	private JTextArea jta;

	public WordItemActionListener(JFrame f, JTextArea jta) {
		this.f = f;
		this.jta = jta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Fontdialog(f, 200, 400, jta);
	}

}
