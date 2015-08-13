package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class SelectAllItemActionListener implements ActionListener {

	private JTextArea jta;
	
	public SelectAllItemActionListener(JTextArea jta) {
		this.jta = jta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jta.setSelectionStart(0);
		jta.setSelectionEnd(jta.getText().length());
	}

}
