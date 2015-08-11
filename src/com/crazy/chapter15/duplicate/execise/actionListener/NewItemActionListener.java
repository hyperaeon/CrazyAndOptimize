package com.crazy.chapter15.duplicate.execise.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NewItemActionListener implements ActionListener {

	private JFrame f;
	private JTextArea jta;

	public NewItemActionListener(JFrame f, JTextArea jta) {
		this.f = f;
		this.jta = jta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (jta.getText().trim().length() > 0) {
			JDialog dialog = new JDialog(f, "记事本", true);
			dialog.setBounds(300, 400, 300, 200);
			
			JTextArea jta = new JTextArea("是否要将修改的内容保存到...", 5, 30);
			
			JButton save = new JButton("保存");
			JButton notSave = new JButton("不保存");
			JButton cancel = new JButton("取消");
			JPanel panel = new JPanel();
			panel.add(save,panel.RIGHT_ALIGNMENT);
			panel.add(notSave,panel.RIGHT_ALIGNMENT);
			panel.add(cancel,panel.RIGHT_ALIGNMENT);
			Box box = Box.createVerticalBox();
			box.add(jta);
			box.add(panel);
			
			dialog.add(box);
			dialog.setVisible(true);
		}
	}

	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

}
