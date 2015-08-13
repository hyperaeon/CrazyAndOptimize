package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

public class PasteItemActionListener implements ActionListener {

	private JTextArea jta;
	private Clipboard clip;

	public PasteItemActionListener(JTextArea jta, Clipboard clip) {
		this.jta = jta;
		this.clip = clip;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (clip.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			String content = null;
			try {
				content = (String) clip.getData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
		}
	}

}
