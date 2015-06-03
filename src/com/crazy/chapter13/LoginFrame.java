package com.crazy.chapter13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame {

	private String driver;
	private String url;
	private String user;
	private String pass;

	private JFrame jf = new JFrame("µÇÂ¼");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("µÇÂ¼");

	public void init() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(Constant.filePath));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
		Class.forName(driver);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validate2(userField.getText(), passField.getText())) {
					JOptionPane.showMessageDialog(jf, "µÇÂ¼³É¹¦");
				} else {
					JOptionPane.showMessageDialog(jf, "µÇÂ¼Ê§°Ü");
				}
			}

		});
		jf.add(userField, BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton, BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);

	}

	private boolean validate(String userName, String userPass) {
		String sql = "select * from jdbc_test " + "where jdbc_name='"
				+ userName + "' and jdbc_desc='" + userPass + "'";
		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean validate2(String userName, String userPass) {
		try(Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = conn.prepareStatement("select * from jdbc_test where jdbc_name =? and jdbc_desc=?");){
			pstmt.setString(1, userName);
			pstmt.setString(2, userPass);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return true;
				}
			}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		new LoginFrame().init();
	}
}
