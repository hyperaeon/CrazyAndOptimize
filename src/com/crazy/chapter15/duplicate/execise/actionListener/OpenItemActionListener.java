package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.crazy.chapter15.duplicate.execise.Constants;

public class OpenItemActionListener implements ActionListener {

	private JFrame f;
	private JTextArea jta;

	public OpenItemActionListener(JFrame f, JTextArea jta) {
		this.f = f;
		this.jta = jta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fileDialog = new FileDialog(f, "打开文件", FileDialog.LOAD);
		fileDialog.setVisible(true);
		// filter the file name.
		fileDialog.setFilenameFilter(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (dir.isFile() && dir.getName().endsWith(".txt")) {
					return true;
				}
				return false;
			}
		});

		if (!jta.getText().isEmpty()) {
			createDialog();
		}
		String fileName = fileDialog.getFile();
		File file = null;
		FileInputStream inputStream = null;
		try {
			/**
			 * open file, put the file content into jta.
			 */
			if (fileName != null && fileName.length() > 0) {
				file = new File(fileName);
				inputStream = new FileInputStream(file);
				FileChannel channel = inputStream.getChannel();
				MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer buffer = decoder.decode(mappedBuffer);
				jta.setText("");//clear the content of jta.
				jta.append(buffer.toString());
			}
		} catch (IOException exception) {
			System.out.println("open file failed");
			exception.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	/**
	 * jta content is not blank and open new file, then create the dialog to confirm. 
	 */
	private void createDialog() {
		final Dialog dialog = new Dialog(f,"保存对话框",true);
		dialog.setBounds(400, 500, 370, 140);
		JTextArea textArea = new JTextArea("是否要保存原有文件到\n", 5, 30);
		textArea.append(Constants.DEFAULT_FILE_PATH_NAME + Constants.TEXT_SUFFIX + " ?");
		textArea.setFont(new Font("宋体", Font.BOLD, 18));//set textArea font
		textArea.setEditable(false);
		JButton save = new JButton("保存");
		JButton notSave = new JButton("不保存");
		JButton cancel = new JButton("取消");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));//set layout
		panel.add(save);
		panel.add(notSave);
		panel.add(cancel);
		Box box = Box.createVerticalBox();
		box.add(textArea);
		box.add(panel);
		
		dialog.add(box);
		dialog.setVisible(true);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked");
			}
		});
//		dialog.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				dialog.dispose();
//				dialog.setVisible(false);
//			}
//		});
		System.out.println("Button clicked");
	}
	
	

}
