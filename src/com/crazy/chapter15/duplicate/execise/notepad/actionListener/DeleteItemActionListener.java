package com.crazy.chapter15.duplicate.execise.notepad.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class DeleteItemActionListener implements ActionListener {

	private JTextArea jta;
	
	public DeleteItemActionListener(JTextArea jta) {
		this.jta = jta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jta.replaceRange("", jta.getSelectionStart(), jta.getSelectionEnd());
	}

}
