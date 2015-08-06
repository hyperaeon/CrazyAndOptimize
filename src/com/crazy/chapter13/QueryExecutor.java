package com.crazy.chapter13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QueryExecutor {

	JFrame jf = new JFrame("≤È—Ø÷¥––∆˜");
	private JScrollPane scrollPane;
	private JButton execBn = new JButton("≤È—Ø");
	private JTextField sqlField = new JTextField(45);
	private static Connection conn;
	private static Statement stmt;

	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(Constant.filePath));
			String drivers = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(drivers);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		JPanel top = new JPanel();
		top.add(new JLabel(" ‰»Î≤È—Ø”Ôæ‰£∫"));
		top.add(sqlField);
		top.add(execBn);
		execBn.addActionListener(new ExceListener());
		sqlField.addActionListener(new ExceListener());
		jf.add(top, BorderLayout.NORTH);
		jf.setSize(640, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	class ExceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (scrollPane != null) {
				jf.remove(scrollPane);
			}
			try (ResultSet rs = stmt.executeQuery(sqlField.getText())) {
				ResultSetMetaData rsmd = rs.getMetaData();
				Vector<String> columnNames = new Vector<>();
				Vector<Vector<String>> data = new Vector<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					columnNames.add(rsmd.getColumnName(i + 1));
				}
				while (rs.next()) {
					Vector<String> v = new Vector<>();
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						v.add(rs.getString(i + 1));
					}
					data.add(v);
				}
				JTable table = new JTable(data, columnNames);
				scrollPane = new JScrollPane(table);
				jf.add(scrollPane);
				jf.validate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new QueryExecutor().init();
	}
}
