package com.crazy.chapter14.excise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompileClassLoader extends ClassLoader {

	/**
	 * @Description: 将文件读取成byte数组 
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午7:20:02
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private byte[] getBytes(File file) throws IOException {
		long len = file.length();
		byte[] raw = new byte[(int)len];
		try (FileInputStream fis = new FileInputStream(file)) {
			int r = fis.read(raw);
			if (r != len) {
				throw new IOException("无法读取全部文件");
			}
			return raw;
		}
	}
	
	/**
	 * 加载class，className为编译后的class的绝对路径
	 */
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		Class<?> clazz = null;
		File classFile = new File(className);
		if (classFile.exists()) {
			try {
				byte[] raw = getBytes(classFile);
				clazz = defineClass(null, raw, 0, raw.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return clazz;
	}
}
