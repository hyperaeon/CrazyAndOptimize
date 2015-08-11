package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.crazy.chapter15.duplicate.execise.Constants;

public class ExitItemActionListener implements ActionListener {

	private JTextArea jta;
	private JFrame f;

	public ExitItemActionListener(JFrame f, JTextArea jta) {
		this.jta = jta;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!jta.getText().isEmpty()) {
			int choice = JOptionPane.showConfirmDialog(f, "是否保存已有内容到\n"
					+ Constants.DEFAULT_FILE_PATH_NAME + Constants.TEXT_SUFFIX
					+ "?", "notepad", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(choice);
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
