package com.crazy.chapter15.duplicate.execise.notepad.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

import com.crazy.chapter15.duplicate.execise.notepad.Constants;

public class SaveItemActionListener implements ActionListener {

	private JTextArea jta;

	public SaveItemActionListener(JTextArea jta) {
		this.jta = jta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(Constants.DEFAULT_FILE_PATH_NAME + Constants.TEXT_SUFFIX);
			fileWriter.write(jta.getText().replaceAll("\n", "\r\n"));
		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

}
