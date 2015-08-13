package com.crazy.chapter15.duplicate.execise.notepad.actionListener;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SaveOtherItemActionListener implements ActionListener {

	private JFrame f;
	private JTextArea jta;

	public SaveOtherItemActionListener(JFrame f, JTextArea jta) {
		this.f = f;
		this.jta = jta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fileDialog = new FileDialog(f, "保存文件", FileDialog.SAVE);
		fileDialog.setVisible(true);
		String fileName = fileDialog.getFile();
		String directory = fileDialog.getDirectory();
		// Save the content.
		FileWriter writer = null;
		try {
			writer = new FileWriter(directory + fileName);
			writer.write(jta.getText().replaceAll("\n", "\r\n"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
