package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

public class DateItemActionListener implements ActionListener {

	private JTextArea jta;
	
	public DateItemActionListener(JTextArea jta) {
		this.jta = jta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jta.replaceRange(sdf.format(date), jta.getSelectionStart(), jta.getSelectionEnd());

	}

}
