package com.crazy.chapter13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;

public class BlobTest {

	JFrame jf = new JFrame("图片管理程序");
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;

	private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
	private JList<ImageHolder> imageList = new JList<>(imageModel);
	private JTextField filePath = new JTextField(26);
	private JButton browserBn = new JButton("...");
	private JButton uploadBn = new JButton("上传");
	private JLabel imageLabel = new JLabel();
	JFileChooser chooser = new JFileChooser(".");
	ExtensionFileFilter filter = new ExtensionFileFilter();
	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(Constant.filePath));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			insert = conn.prepareStatement(
					"insert into img_table values(null, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			query = conn
					.prepareStatement("select img_data from img_table where img_id=?");
			queryAll = conn
					.prepareStatement("select img_id,img_name from img_table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws SQLException {
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		fillListModel();
		filePath.setEditable(false);
		imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp = new JPanel();
		jp.add(filePath);
		jp.add(browserBn);
		browserBn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showDialog(jf, "浏览图片文件上传");
				if (result == JFileChooser.APPROVE_OPTION) {
					filePath.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		jp.add(uploadBn);
		uploadBn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (filePath.getText().trim().length() > 0) {
					upload(filePath.getText());
					filePath.setText("");
				}
			}

		});
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
		left.add(jp, BorderLayout.SOUTH);
		jf.add(left);
		imageList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imageList), BorderLayout.EAST);
		imageList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					ImageHolder cur = (ImageHolder) imageList
							.getSelectedValue();
					try {
						showImage(cur.getId());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}

			
		});
		jf.setSize(630, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	private void fillListModel() throws SQLException {
		try (ResultSet rs = queryAll.executeQuery()) {
			imageModel.clear();
			while (rs.next()) {
				imageModel.addElement(new ImageHolder(rs.getInt(1), rs
						.getString(2)));
			}
		}

	}

	private void upload(String fileName) {
		String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1,
				fileName.lastIndexOf('.'));
		File f = new File(fileName);
		try (
			InputStream is = new FileInputStream(f)) {
			insert.setString(1, imageName);
			insert.setBinaryStream(2, is, (int) f.length());
			int affect = insert.executeUpdate();
			if (affect == 1) {
				fillListModel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showImage(int id) throws SQLException {
		query.setInt(1, id);
		try(ResultSet rs = query.executeQuery()) {
			if (rs.next()) {
				Blob imgBlob = rs.getBlob(1);
				ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
				imageLabel.setIcon(icon);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new BlobTest().init();
	}
} 

class ExtensionFileFilter extends FileFilter {
	private String description = "";
	private ArrayList<String> extensions = new ArrayList<>();

	public void addExtension(String extension) {
		if (!extension.startsWith(".")) {
			extension = '.' + extension;
			extensions.add(extension.toLowerCase());
		}
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String name = f.getName().toLowerCase();
		for (String extension : extensions) {
			if (name.endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}

class ImageHolder {
	private int id;
	private String name;

	public ImageHolder() {
	}

	public ImageHolder(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}