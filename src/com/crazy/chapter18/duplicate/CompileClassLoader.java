package com.crazy.chapter18.duplicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader {

	private byte[] getBytes(String fileName) throws IOException {
		File file = new File(fileName);
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
	
	private boolean compile(String javaFile) throws IOException {
		System.out.println("compile正在编译：" + javaFile + "...");
		Process p = Runtime.getRuntime().exec("javac " + javaFile);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		int ret = p.exitValue();
		return ret == 0;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		String fileStub = name.replace(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		if (javaFile.exists() && (!classFile.exists())
				|| javaFile.lastModified() > classFile.lastModified()) {
			try {
				if (!compile(javaFileName)
						|| !classFile.exists()) {
					throw new ClassNotFoundException("not found");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (classFile.exists()) {
			try {
				byte[] raw = getBytes(classFileName);
				clazz = defineClass( raw, 0, raw.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	
	public static void main(String[] args) throws Exception {
//		if (args.length < 1) {
//			System.out.println("usage: java compileClassLoader ClassName");
//		}
//		String progClass = 	args[0];
		String[] progArgs = new String[args.length - 1];
//		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		String progClass = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\target\\classes\\com\\crazy\\chapter18\\duplicate\\FieldTest";
		Class<?> clazz = ccl.loadClass(progClass);
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = {progArgs};
		main.invoke(null, argsArray);
	}
}
