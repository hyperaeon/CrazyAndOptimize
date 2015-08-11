package com.crazy.chapter15.duplicate.execise.action;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.crazy.chapter15.duplicate.execise.Constants;

public class ConfirmDialogAction {

	private JFrame f;
	private JTextArea jta;

	public ConfirmDialogAction(JFrame f, JTextArea jta) {
		this.f = f;
		this.jta = jta;
	}

	public void dialog() {
		if (!jta.getText().isEmpty()) {
			int choice = JOptionPane.showConfirmDialog(f, "是否保存已有内容到\n"
					+ Constants.DEFAULT_FILE_PATH_NAME + Constants.TEXT_SUFFIX
					+ "?", "notepad", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				saveFile();
			} else {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}
	
	/**
	 * save the content to file.
	 */
	private void saveFile() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(Constants.DEFAULT_FILE_PATH_NAME
					+ Constants.TEXT_SUFFIX);
			writer.write(jta.getText().replaceAll("\n", "\r\n"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.exit(0);
	}
}
