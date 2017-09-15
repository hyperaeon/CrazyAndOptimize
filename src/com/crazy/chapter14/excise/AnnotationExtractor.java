package com.crazy.chapter14.excise;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.netease.print.daojar.meta.annotation.AnnonOfClass;

public class AnnotationExtractor {
	
	private static final String CREATE_PRIFX = "CREATE TABLE ";
	
	private static final Set<String> PATH_SET = new HashSet<>();//所有meta类的绝对路径集合
	
	private static final List<String> PATH_LIST = new ArrayList<>();//meta类的编译文件的路径列表
	
	private static final String PATH_PREFIX = "D:\\beauty-service\\beauty-service\\";//路径的前缀
	
	private static final List<Class<?>> CLASS_LIST = new ArrayList<>();//类列表
	
	private static final Map<Class<?>, String> CLASS_CREATETABLE_MAP = new HashMap<>();//类和类对应的建表语句的映射
	
	private static final String COMMENT = "COMMENT";
	
	private static final Map<Class<?>, String> CLASS_TABLETYPE_MAP = new HashMap<>();//java类型与数据库类型的映射 
	
	static {
		PATH_LIST.add(PATH_PREFIX + "beauty-activity\\beauty-activity-api\\target\\classes\\com\\netease\\beauty\\activity\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-content\\beauty-content-api\\target\\classes\\com\\netease\\beauty\\content\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-ic\\beauty-ic-api\\target\\classes\\com\\netease\\beauty\\ic\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-qa\\beauty-qa-api\\target\\classes\\com\\netease\\beauty\\qa\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-sns\\beauty-sns-api\\target\\classes\\com\\netease\\beauty\\sns\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-ugc\\beauty-ugc-api\\target\\classes\\com\\netease\\beauty\\ugc\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-user\\beauty-user-api\\target\\classes\\com\\netease\\beauty\\user\\meta");
		
		CLASS_TABLETYPE_MAP.put(Long.class, "bigint");
		CLASS_TABLETYPE_MAP.put(String.class, "text");
		CLASS_TABLETYPE_MAP.put(Integer.class, "int");
		CLASS_TABLETYPE_MAP.put(Date.class, "timestamp");
		CLASS_TABLETYPE_MAP.put(BigDecimal.class, "decimal");
	}

	/**
	 * 符号 
	 * @author hzliyong
	 *
	 */
	public interface Symbol {
		String LEFT_BRACKETS = "(";
		
		String RIGHT_BRACKETS = ");";
		
		String COMMA = ",";
		
		String ANTI_QUOTA = "`";
		
		String QUOTA = "'";
		
		String BLANK_SPACE = " ";
	}
	
	public static void process(String path, String clazzName) throws ClassNotFoundException {
		Class clazz = Class.forName(clazzName);
		process(clazz);
	}
	
	/**
	 * @Description: 
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午7:16:06
	 * @param clazz
	 * @throws ClassNotFoundException
	 */
	public static void process(Class<?> clazz) throws ClassNotFoundException {
		boolean isAnnonOfClass = clazz.isAnnotationPresent(AnnonOfClass.class);//是否有AnnonOfClass修饰
		if (isAnnonOfClass) {
			Field[] fields = clazz.getDeclaredFields();
			Annotation[] annotations = clazz.getAnnotations();//获取类的注释
			if (annotations != null) {
				StringBuilder builder = new StringBuilder(CREATE_PRIFX).append(Symbol.LEFT_BRACKETS);
				for (Annotation annotation : annotations) {
					if (annotation instanceof AnnonOfClass) {
						AnnonOfClass aoc = (AnnonOfClass)annotation;//转换成具体的注释
						builder.append(wrapperString(aoc.tableName()));//添加表名
						String cc = aoc.desc();
						
						if (fields != null) {
//				for (Field field : fields) {
//					if ()
//				}
						}
					}
				}
			}
		}
	}
	
	/**
	 * @Description: 字符串两边加上反单引号 
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午9:43:57
	 * @param str
	 * @return
	 */
	private static String wrapperString(String str) {
		return Symbol.ANTI_QUOTA + str + Symbol.ANTI_QUOTA;
	}
	
	/**
	 * @Description: 遍历PATH_LIST查找所有meta类对应的class文件，将文件的路径放到PATH_SET中
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午7:41:56
	 * @param path
	 */
	public static void findMetaClassToSet() {
		File root = null;
		File[] files = null;
		for (String path : PATH_LIST) {
			root = new File(path);
			files = root.listFiles();
			if (files != null) {
				for (File file : files) {
					PATH_SET.add(file.getAbsolutePath());
				}
			}
		}
		
	}
	
	/**
	 * @Description: 使用classLoader加载PATH_SET中的文件到CLASS_LIST中
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午8:14:58
	 * @param classLoader
	 * @throws ClassNotFoundException
	 */
	private static void loadClassToList(CompileClassLoader classLoader) throws ClassNotFoundException {
		for (String path : PATH_SET) {
			Class<?> clazz = classLoader.findClass(path);
			if (clazz != null) {
				CLASS_LIST.add(clazz);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
//		String path = "";
//		String clazzName = "com.netease.beauty.ugc.meta.Repo";
//		try {
//			process(path, clazzName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		findMetaClassToSet();
//		for (String p : PATH_SET) {
//			System.out.println(p);
//		}
		CompileClassLoader cc = new CompileClassLoader();
		loadClassToList(cc);
		for (Class<?> clazz : CLASS_LIST) {
			System.out.println(clazz.getName());
		}
		System.out.println(CLASS_LIST.size());
	}
}
