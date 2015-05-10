package com.crazy.chapter14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnotationListenerTest {

	private JFrame mainWin = new JFrame("ʹ��ע����¼�����");
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok = new JButton("ȷ��");
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel = new JButton("ȡ��");
	public void init(){
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotation(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args) {
		new AnnotationListenerTest().init();
	}

}
class OkListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "�����ȷ�ϰ�ť");
	}
	
}
class CancelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "�����ȡ����ť");
	}
	
}
