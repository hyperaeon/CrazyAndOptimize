//package com.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.util.StringUtils;
//
//import com.netease.print.daojar.meta.annotation.AnnonOfClass;
//import com.netease.print.daojar.meta.annotation.AnnonOfField;
//
//
///**
// * 将meta类转换成建表语句保存到本地文件
// *
// * 注意：生成sql语句后text类型可能需要修改成varchar类型；索引如果要新增的话需要再添加；POLICY可能需要修改，默认是user
// *
// * @author ly
// *
// */
//public class MetaToSqlUtil {
//
//	private static final String CREATE_PRIFX = "CREATE TABLE ";
//
//	private static final Set<String> PATH_SET = new LinkedHashSet<>();//所有meta类的绝对路径集合，此处需要使用LinkedHashMap，因为要维护类的加载顺序
//
//	private static final List<String> PATH_LIST = new ArrayList<>();//meta类的编译文件的路径列表
//
//	private static final String PATH_PREFIX = "D:\\beauty-service\\beauty-service\\";//路径的前缀
//
//	private static final List<Class<?>> CLASS_LIST = new ArrayList<>();//类列表
//
//	private static final Map<Class<?>, String> CLASS_CREATETABLE_MAP = new HashMap<>();//类和类对应的建表语句的映射
//
//	private static final Map<String, Class<?>> CLASS_NAME_CLASS_MAP = new HashMap<>();//类的全限定名与Class的映射
//
//	private static final String COMMENT = "COMMENT";
//
//	private static final String PRIAMARY_KEY = "PRIMARY KEY ";
//
//	private static final String SUFFIX = " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='%s'/* BF=id, POLICY=user, STARTID=10000, ASSIGNIDTYPE=USB */;";//建表语句的后缀
//
////	private static final Map<String, String> CLASS_TABLETYPE_MAP = new HashMap<>();//java类型与数据库类型的映射
//
//	private static final String DEST_PATH = "E:\\Doc\\新美\\任务\\createTable.sql";//保存的目标路径
//
//	private static final String CREATE_UPDATE_DATE = "\t`db_create_time` timestamp NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',\n" +
//			"\t`db_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n";//db创建或修改语句
//
//
//	static {
//		PATH_LIST.add(PATH_PREFIX + "beauty-activity\\beauty-activity-api\\target\\classes\\com\\netease\\beauty\\activity\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-content\\beauty-content-api\\target\\classes\\com\\netease\\beauty\\content\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-ic\\beauty-ic-api\\target\\classes\\com\\netease\\beauty\\ic\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-qa\\beauty-qa-api\\target\\classes\\com\\netease\\beauty\\qa\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-sns\\beauty-sns-api\\target\\classes\\com\\netease\\beauty\\sns\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-ugc\\beauty-ugc-api\\target\\classes\\com\\netease\\beauty\\ugc\\meta");
//		PATH_LIST.add(PATH_PREFIX + "beauty-user\\beauty-user-api\\target\\classes\\com\\netease\\beauty\\user\\meta");
//		//由于meta中有枚举dto等类，因此需要加载到虚拟机中
//		PATH_LIST.add("D:\\beauty-service\\beauty-service\\beauty-common\\target\\classes\\com\\netease\\beauty\\common\\constants\\enums");
//		PATH_LIST.add("D:\\beauty-service\\beauty-service\\beauty-sns\\beauty-sns-api\\target\\classes\\com\\netease\\beauty\\sns\\dto");
//
////		CLASS_TABLETYPE_MAP.put("long", "bigint");
////		CLASS_TABLETYPE_MAP.put("class java.lang.Long", "bigint");
////		CLASS_TABLETYPE_MAP.put("class java.lang.String", "text");
////		CLASS_TABLETYPE_MAP.put("class java.lang.Integer", "int");
////		CLASS_TABLETYPE_MAP.put("int", "int");
////		CLASS_TABLETYPE_MAP.put("class java.util.Date", "timestamp");
////		CLASS_TABLETYPE_MAP.put("class java.math.BigDecimal", "decimal");
////		CLASS_TABLETYPE_MAP.put("class java.lang.Boolean", "tinyint");
////		CLASS_TABLETYPE_MAP.put("boolean", "tinyint");
//	}
//
//	/**
//	 * 符号
//	 * @author ly
//	 *
//	 */
//	class Symbol {
//		private Symbol() {}
//
//		public static final String LEFT_BRACKETS = " (";
//
//		public static final String RIGHT_BRACKETS = ")";
//
//		public static final String COMMA = ",";
//
//		public static final String ANTI_QUOTA = "`";
//
//		public static final String QUOTA = "'";
//
//		public static final String BLANK_SPACE = " ";
//
//		public static final String TAB = "\t";
//
//		public static final String ENTER = "\n";
//	}
//
//	public static void processToCreate(String clazzName) throws ClassNotFoundException {
//		Class<?> clazz = Class.forName(clazzName);
//		processToCreate(clazz);
//	}
//
//	/**
//	 * @Description: 将clazz转换成建表语句
//	 * @Author: ly
//	 * @Date: 2017年9月14日
//	 * @Time: 下午7:16:06
//	 * @param clazz
//	 * @throws ClassNotFoundException
//	 */
//	public static String processToCreate(Class<?> clazz) throws ClassNotFoundException {
//		boolean isAnnonOfClass = clazz.isAnnotationPresent(AnnonOfClass.class);//是否有AnnonOfClass修饰
//		StringBuilder builder = new StringBuilder();
//		if (isAnnonOfClass) {
//			Field[] fields = clazz.getDeclaredFields();
//			Annotation[] annotations = clazz.getAnnotations();//获取类的注释
//			if (annotations != null) {
//				builder.append(CREATE_PRIFX);
//				for (Annotation annotation : annotations) {
//					if (annotation instanceof AnnonOfClass) {
//						AnnonOfClass aoc = (AnnonOfClass)annotation;//转换成具体的注释
//						builder.append(wrapperWithAntiQuota(aoc.tableName()))
//							.append(Symbol.LEFT_BRACKETS)//添加表名
//							.append(Symbol.ENTER);
//						//处理每个字段的注释，追加到builder中
//						handleField(builder, fields);
//						builder.append(Symbol.RIGHT_BRACKETS).append(getSuffix(aoc.desc()))
//						.append(Symbol.ENTER).append(Symbol.ENTER);
//						break;
//					}
//				}
//			}
//		}
//		return builder.toString();
//	}
//
//
//
//	/**
//	 * 获取创建表的后缀
//	 * @param desc
//	 * @return
//	 */
//	private static String getSuffix(String desc) {
//		return SUFFIX.replaceAll("%s", desc);
//	}
//
//	/**
//	 * 处理每个字段的注释，追加到builder中
//	 * @param builder
//	 * @param fields
//	 */
//	private static void handleField(StringBuilder builder, Field[] fields) {
//		if (fields != null) {
//			String primaryKey = "";
//			boolean isDbCreateTimeExist = false;
//			for (Field field : fields) {
//				if (field.isAnnotationPresent(AnnonOfField.class)) {
//					AnnonOfField aof = field.getAnnotation(AnnonOfField.class);
//					if (aof != null
//							&& aof.inDB()) {
//						String fieldName = field.getName();//字段名
//						//获取字段的类型
//						String fieldType = getFieldType(field.getType());
//						String description = aof.desc();//描述
//						builder.append(Symbol.TAB);//添加空格
//						builder.append(wrapperWithAntiQuota(fieldName)).append(Symbol.BLANK_SPACE);//添加字段名
//						builder.append(fieldType).append(Symbol.BLANK_SPACE);//添加字段类型
//						builder.append(COMMENT).append(Symbol.BLANK_SPACE);//添加描述关键字
//						builder.append(wrapWithQuota(description)).append(Symbol.COMMA).append(Symbol.ENTER);//添加描述
//						if (aof.primary()) {//主键
//							primaryKey = PRIAMARY_KEY + wrapWithBrackets(fieldName);
//						}
//						if ("db_create_time".equals(fieldName)) {
//							isDbCreateTimeExist = true;
//						}
//					}
//				}
//			}
//			if (!isDbCreateTimeExist) {
//				builder.append(CREATE_UPDATE_DATE);//追加db创建和修改时间
//			}
//			if (!StringUtils.isEmpty(primaryKey)) {//添加主键描述
//				builder.append(Symbol.TAB).append(primaryKey).append(Symbol.ENTER);
//			}
//		}
//	}
//
//	/**
//	 * 根据字段的class类型获取数据库对应的类型
//	 * @param type
//	 * @return
//	 */
//	private static String getFieldType(Class<?> type) {
//		String strType = "";
//		if (type.getName().contains("enums")) {//枚举类的都转换成tinyint
//			strType = "tinyint";
//		} else if (Integer.class.equals(type)
//				|| "int".equalsIgnoreCase(type.getName())) {
//			strType = "int";
//		} else if (Long.class.equals(type)
//				|| "long".equalsIgnoreCase(type.getName())) {
//			strType = "bigint(20)";
//		} else if (String.class.equals(type)) {
//			strType = "text";
//		} else if (Date.class.equals(type)) {
//			strType = "timestamp";
//		} else if (BigDecimal.class.equals(type)) {
//			strType = "decimal";
//		} else if (Boolean.class.equals(type)
//				|| "boolean".equalsIgnoreCase(type.getName())) {
//			strType = "tinyint";
//		} else {
//			strType = type.getName();
//		}
////		String strType = CLASS_TABLETYPE_MAP.get(type);
////		if (!StringUtils.isBlank(strType)
////				&& type.contains("enums")) {//枚举类的都转换成tinyint
////			strType = "tinyint";
////		} else {
////			strType = type;
////		}
//		return strType;
//	}
//
//	/**
//	 * @Description: 用单引号包裹str
//	 * @Author: ly
//	 * @Date: 2017年9月14日
//	 * @Time: 下午9:43:57
//	 * @param str
//	 * @return
//	 */
//	private static String wrapperWithAntiQuota(String str) {
//		return wrapWithSymbol(str, Symbol.ANTI_QUOTA);
//	}
//
//	/**
//	 * 用单引号包裹str
//	 * @param str
//	 * @return
//	 */
//	private static String wrapWithQuota(String str) {
//		return wrapWithSymbol(str, Symbol.QUOTA);
//	}
//
//	/**
//	 * 用括号包裹str
//	 * @param str
//	 * @return
//	 */
//	private static String wrapWithBrackets(String str) {
//		return Symbol.LEFT_BRACKETS + str + Symbol.RIGHT_BRACKETS;
//	}
//
//	/**
//	 * 用symbol包裹str
//	 * @param str
//	 * @param symbol
//	 * @return
//	 */
//	private static String wrapWithSymbol(String str, String symbol) {
//		return symbol + str + symbol;
//	}
//
//	/**
//	 * @Description: 遍历PATH_LIST查找所有meta类对应的class文件，将文件的路径放到PATH_SET中
//	 * @Author: ly
//	 * @Date: 2017年9月14日
//	 * @Time: 下午7:41:56
//	 * @param path
//	 */
//	public static void findMetaClassToSet() {
//		File root = null;
//		File[] files = null;
//		for (String path : PATH_LIST) {
//			root = new File(path);
//			files = root.listFiles();
//			if (files != null) {
//				for (File file : files) {
//					PATH_SET.add(file.getAbsolutePath());
//				}
//			}
//		}
//
//	}
//
//	/**
//	 * @Description: 使用classLoader加载PATH_SET中的文件到CLASS_LIST中
//	 * @Author: ly
//	 * @Date: 2017年9月14日
//	 * @Time: 下午8:14:58
//	 * @param classLoader
//	 * @throws ClassNotFoundException
//	 */
//	private static void loadClassToList(CompileClassLoader classLoader) throws ClassNotFoundException {
//		for (String path : PATH_SET) {
//			Class<?> clazz = classLoader.findClass(path);
//			if (clazz != null) {
//				String name = clazz.getName();
//				if (!name.contains("enums")) {//将非枚举类保存到CLASS_LIST中
//					CLASS_LIST.add(clazz);
//				}
//			}
//		}
//	}
//
//	/**
//	 * 将create的sql语句保存到文件中
//	 */
//	private static void saveCreateTableToFile() throws Exception {
//		File file = new File(DEST_PATH);
//		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
//			for (Map.Entry<Class<?>, String> entry : CLASS_CREATETABLE_MAP.entrySet()) {
//				raf.write(entry.getValue().getBytes());
//			}
//		}
//	}
//
//	/**
//	 * @Description:
//	 * 1、将所有class文件绝对路径放到PATH_SET中
//	 * 2、装载Class到CLASS_LIST
//	 * 3、循环对class类进行解析，将其转化成建表语句，放到CLASS_CREATETABLE_MAP中
//	 * 4、将建表语句保存到本地
//	 * @Author: ly
//	 * @Date: 2017年9月21日
//	 * @Time: 下午5:18:27
//	 */
//	private static void createTableToFile() throws Exception {
//		// 先将所有class文件绝对路径放到PATH_SET中
//		findMetaClassToSet();
//		CompileClassLoader cc = new CompileClassLoader();
//		try {
//			// 装载Class到CLASS_LIST
//			loadClassToList(cc);
//		} catch (ClassNotFoundException e) {
//			System.exit(0);
//		}
//		// 循环对class类进行解析，将其转化成建表语句，放到CLASS_CREATETABLE_MAP中
//		for (Class<?> clazz : CLASS_LIST) {
//			CLASS_CREATETABLE_MAP.put(clazz, processToCreate(clazz));
//			CLASS_NAME_CLASS_MAP.put(clazz.getName(), clazz);
//		}
//		// 将建表语句保存到本地
//		saveCreateTableToFile();
//	}
//
//	/**
//	 *
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		//将meta转换成建表语句并保存到本地
//		createTableToFile();
//		//可以选定class进行打印
//		String className = "com.netease.beauty.content.meta.ExchangeRate";
//		String sql = CLASS_CREATETABLE_MAP.get(CLASS_NAME_CLASS_MAP.get(className));
//		System.out.println(sql);
//	}
//}
//
//class CompileClassLoader extends ClassLoader {
//
//	/**
//	 * @Description: 将文件读取成byte数组
//	 * @Author: ly
//	 * @Date: 2017年9月14日
//	 * @Time: 下午7:20:02
//	 * @param fileName
//	 * @return
//	 * @throws IOException
//	 */
//	private byte[] getBytes(File file) throws IOException {
//		long len = file.length();
//		byte[] raw = new byte[(int)len];
//		try (FileInputStream fis = new FileInputStream(file)) {
//			int r = fis.read(raw);
//			if (r != len) {
//				throw new IOException("无法读取全部文件");
//			}
//			return raw;
//		}
//	}
//
//	/**
//	 * 加载class，className为编译后的class的绝对路径
//	 */
//	protected Class<?> findClass(String className) throws ClassNotFoundException {
//		Class<?> clazz = null;
//		File classFile = new File(className);
//		if (classFile.exists()) {
//			try {
//				byte[] raw = getBytes(classFile);
//				clazz = defineClass(null, raw, 0, raw.length);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return clazz;
//	}
//}