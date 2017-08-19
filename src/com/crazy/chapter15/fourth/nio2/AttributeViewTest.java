package com.crazy.chapter15.fourth.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.List;

public class AttributeViewTest {

	public static void main(String[] args) throws Exception {
		Path testPath = Paths.get("C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\nio2\\AttributeViewTest.java");
		BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, 
				BasicFileAttributeView.class);
		BasicFileAttributes basicAttribs = basicView.readAttributes();
		System.out.println("CreateTime: " + new Date(basicAttribs.creationTime().toMillis()));
		
		FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, 
				FileOwnerAttributeView.class);
		System.out.println(ownerView.getOwner());
		UserPrincipal user = FileSystems.getDefault().
				getUserPrincipalLookupService().lookupPrincipalByName("guest");
		
		UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, 
				UserDefinedFileAttributeView.class);
		List<String> attrNames = userView.list();
			attrNames.forEach(name -> {
				try {
					ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
					userView.read(name, buf);
					buf.flip();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		for (String name : attrNames) {
			ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
			userView.read(name, buf);
			buf.flip();
		}
	}
}
