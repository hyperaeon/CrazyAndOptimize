package com.crazy.chapter15.duplicate.execise.action;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fontdialog implements ActionListener, ItemListener {

	List fontname, fontshape, fontsize;

	JPanel pname, pshape, psize, pmodel, prb;

	JTextField txtname, txtshape, txtsize;

	JTextArea txtmodel;

	JDialog dialog;

	JButton btnok, btncancel;

	JRadioButton rbzw, rbyw, rbsz;

	public Font modelfont;

	public Fontdialog(JFrame f, int x, int y) {
		GraphicsEnvironment g = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String name[] = g.getAvailableFontFamilyNames();
		String shape[] = { "常规", "斜体", "粗体倾斜", "粗体" };
		fontname = new List();
		fontshape = new List();
		fontsize = new List();
		rbzw = new JRadioButton("中文");
		rbyw = new JRadioButton("英文");
		rbsz = new JRadioButton("数字");
		ButtonGroup group = new ButtonGroup();
		prb = new JPanel();
		group.add(rbzw);
		group.add(rbyw);
		group.add(rbsz);
		txtmodel = new JTextArea();
		txtmodel.setText("中华人民共和国");
		rbzw.setSelected(true);
		btnok = new JButton("确定");
		btncancel = new JButton("取消");

		// 添加监听器
		fontname.addItemListener(this);
		fontshape.addItemListener(this);
		fontsize.addItemListener(this);
		btnok.addActionListener(this);
		btncancel.addActionListener(this);
		rbzw.addItemListener(this);
		rbyw.addItemListener(this);
		rbsz.addItemListener(this);
		for (int i = 0; i < name.length; i++)
			fontname.addItem(name[i]);
		for (int i = 0; i < 200; i++)
			fontsize.addItem(Integer.toString(i + 10));
		for (int i = 0; i < shape.length; i++)
			fontshape.addItem(shape[i]);
		fontname.select(175);
		fontshape.select(1);
		fontsize.select(22);
		pname = new JPanel();
		pshape = new JPanel();
		psize = new JPanel();
		pmodel = new JPanel();
		txtname = new JTextField(12);
		txtshape = new JTextField(12);
		txtsize = new JTextField(20);
		txtname.setText(fontname.getSelectedItem());
		txtshape.setText(fontshape.getSelectedItem());
		txtsize.setText(fontsize.getSelectedItem());
		dialog = new JDialog(f, "字体", true);
		dialog.setLayout(null);
		pname.setBorder(BorderFactory.createTitledBorder("字体"));
		pshape.setBorder(BorderFactory.createTitledBorder("字形"));
		psize.setBorder(BorderFactory.createTitledBorder("大小"));
		pmodel.setBorder(BorderFactory.createTitledBorder("示例"));
		prb.setBorder(BorderFactory.createTitledBorder("字符集"));
		pname.setBounds(10, 10, 190, 170);
		pshape.setBounds(210, 10, 160, 170);
		psize.setBounds(380, 10, 80, 170);
		pmodel.setBounds(150, 200, 300, 120);
		prb.setBounds(10, 200, 100, 120);
		rbzw.setBounds(25, 220, 60, 25);
		rbyw.setBounds(25, 250, 60, 25);
		rbsz.setBounds(25, 280, 60, 25);
		txtname.setBounds(30, 30, 160, 22);
		txtshape.setBounds(220, 30, 140, 22);
		txtsize.setBounds(390, 30, 60, 22);
		fontname.setBounds(30, 65, 160, 100);
		fontshape.setBounds(220, 65, 140, 100);
		fontsize.setBounds(390, 65, 60, 100);
		txtmodel.setBounds(175, 220, 250, 85);
		btnok.setBounds(140, 340, 65, 30);
		btncancel.setBounds(250, 340, 65, 30);
		// pshape.setBounds();
		dialog.add(txtname);
		dialog.add(txtshape);
		dialog.add(fontname);
		dialog.add(fontshape);
		dialog.add(fontsize);
		dialog.add(txtsize);
		dialog.add(pname);
		dialog.add(pshape);
		dialog.add(psize);
		dialog.add(txtmodel);
		dialog.add(pmodel);
		dialog.add(rbzw);
		dialog.add(rbyw);
		dialog.add(rbsz);
		dialog.add(prb);
		dialog.add(btnok);
		dialog.add(btncancel);
		dialog.setSize(480, 440);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.show();
	}

	public void actionPerformed(ActionEvent e) {
	}

	public void itemStateChanged(ItemEvent e) {
		try {
			if (e.getSource() == rbzw)
				txtmodel.setText("中华人民共和国");
			if (e.getSource() == rbyw)
				txtmodel.setText("ABCDEFabcdef");
			if (e.getSource() == rbsz)
				txtmodel.setText("0123456789");
			if (fontshape.getSelectedItem() == "粗体") {
				modelfont = new Font(fontname.getSelectedItem(), Font.BOLD,
						Integer.parseInt(fontsize.getSelectedItem()));
				txtmodel.setFont(modelfont);
			}
			if (fontshape.getSelectedItem() == "斜体") {
				modelfont = new Font(fontname.getSelectedItem(), Font.ITALIC,
						Integer.parseInt(fontsize.getSelectedItem()));
				txtmodel.setFont(modelfont);
			}
			if (fontshape.getSelectedItem() == "粗体倾斜") {
				modelfont = new Font(fontname.getSelectedItem(), Font.BOLD
						| Font.ITALIC, Integer.parseInt(fontsize
						.getSelectedItem()));
				txtmodel.setFont(modelfont);
			}
			if (fontshape.getSelectedItem() == "常规") {
				modelfont = new Font(fontname.getSelectedItem(), Font.PLAIN,
						Integer.parseInt(fontsize.getSelectedItem()));
				txtmodel.setFont(modelfont);
			}
			txtname.setText(fontname.getSelectedItem());
			txtshape.setText(fontshape.getSelectedItem());
			txtsize.setText(fontsize.getSelectedItem());
		} catch (Exception ex) {
		}

	}
}
