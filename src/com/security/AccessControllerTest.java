package com.security;

import java.io.FilePermission;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class AccessControllerTest {

	public static void main(String[] args) {
		FilePermission fp = new FilePermission("E:/Work/config/dev/datasource.xml", "write");
		System.out.println(System.getSecurityManager());
		AccessController.doPrivileged(new PrivilegedAction<String>() {

			public String run() {
				FilePermission fp = new FilePermission("E:/Work/config/dev/datasource.xml", "write");
//				AccessController.checkPermission(fp);
				return "";
			}
		});
	}
}
