package com.crazy.chapter15.duplicate.execise.notepad.actionListener;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class CutItemActionListener implements ActionListener {

	private JTextArea jta;
	private Clipboard clip;
	
	public CutItemActionListener (JTextArea jta, Clipboard clip) {
		this.jta = jta;
		this.clip = clip;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!jta.getSelectedText().isEmpty()) {
			clip.setContents(new StringSelection(jta.getSelectedText()), null);
			jta.replaceRange("", jta.getSelectionStart(), jta.getSelectionEnd());
		}
	}

}
