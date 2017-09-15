package com.crazy.chapter14.excise;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.netease.print.daojar.meta.annotation.AnnonOfClass;
import com.netease.print.daojar.meta.annotation.AnnonOfField;

import wiremock.org.apache.commons.lang.StringUtils;

/**
 * 将meta类转换成建表语句保存到本地文件
 * @author hzliyong
 *
 */
public class AnnotationExtractor {
	
	private static final String CREATE_PRIFX = "CREATE TABLE ";
	
	private static final Set<String> PATH_SET = new LinkedHashSet<>();//所有meta类的绝对路径集合，此处需要使用LinkedHashMap，因为要维护类的加载顺序
	
	private static final List<String> PATH_LIST = new ArrayList<>();//meta类的编译文件的路径列表
	
	private static final String PATH_PREFIX = "D:\\beauty-service\\beauty-service\\";//路径的前缀
	
	private static final List<Class<?>> CLASS_LIST = new ArrayList<>();//类列表
	
	private static final Map<Class<?>, String> CLASS_CREATETABLE_MAP = new HashMap<>();//类和类对应的建表语句的映射
	
	private static final String COMMENT = "COMMENT";
	
	private static final String SUFFIX = " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='%s'/* BF=id, POLICY=user, STARTID=0, ASSIGNIDTYPE=USB */;";//建表语句的后缀
	
	private static final Map<String, String> CLASS_TABLETYPE_MAP = new HashMap<>();//java类型与数据库类型的映射 
	
	private static final String SAVE_PATH = "E:\\Doc\\新美\\任务\\createTable.sql";//保存路径
	
	static {
		PATH_LIST.add(PATH_PREFIX + "beauty-activity\\beauty-activity-api\\target\\classes\\com\\netease\\beauty\\activity\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-content\\beauty-content-api\\target\\classes\\com\\netease\\beauty\\content\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-ic\\beauty-ic-api\\target\\classes\\com\\netease\\beauty\\ic\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-qa\\beauty-qa-api\\target\\classes\\com\\netease\\beauty\\qa\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-sns\\beauty-sns-api\\target\\classes\\com\\netease\\beauty\\sns\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-ugc\\beauty-ugc-api\\target\\classes\\com\\netease\\beauty\\ugc\\meta");
		PATH_LIST.add(PATH_PREFIX + "beauty-user\\beauty-user-api\\target\\classes\\com\\netease\\beauty\\user\\meta");
		//由于meta中有枚举dto等，因此需要加载到虚拟机中
		PATH_LIST.add("D:\\beauty-service\\beauty-service\\beauty-common\\target\\classes\\com\\netease\\beauty\\common\\constants\\enums");
		PATH_LIST.add("D:\\beauty-service\\beauty-service\\beauty-sns\\beauty-sns-api\\target\\classes\\com\\netease\\beauty\\sns\\dto");
		
		CLASS_TABLETYPE_MAP.put("long", "bigint");
		CLASS_TABLETYPE_MAP.put("class java.lang.Long", "bigint");
		CLASS_TABLETYPE_MAP.put("class java.lang.String", "text");
		CLASS_TABLETYPE_MAP.put("class java.lang.Integer", "int");
		CLASS_TABLETYPE_MAP.put("int", "int");
		CLASS_TABLETYPE_MAP.put("class java.util.Date", "timestamp");
		CLASS_TABLETYPE_MAP.put("class java.math.BigDecimal", "decimal");
		CLASS_TABLETYPE_MAP.put("class java.lang.Boolean", "tinyint");
		CLASS_TABLETYPE_MAP.put("boolean", "tinyint");
	}

	/**
	 * 符号 
	 * @author hzliyong
	 *
	 */
	public interface Symbol {
		String LEFT_BRACKETS = " (";
		
		String RIGHT_BRACKETS = ")";
		
		String COMMA = ",";
		
		String ANTI_QUOTA = "`";
		
		String QUOTA = "'";
		
		String BLANK_SPACE = " ";
		
		String TAB = "\t";
		
		String ENTER = "\n";
	}
	
	public static void processToCreate(String clazzName) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(clazzName);
		processToCreate(clazz);
	}
	
	/**
	 * @Description: 将clazz转换成建表语句 
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午7:16:06
	 * @param clazz
	 * @throws ClassNotFoundException
	 */
	public static String processToCreate(Class<?> clazz) throws ClassNotFoundException {
		boolean isAnnonOfClass = clazz.isAnnotationPresent(AnnonOfClass.class);//是否有AnnonOfClass修饰
		StringBuilder builder = new StringBuilder();
		if (isAnnonOfClass) {
			Field[] fields = clazz.getDeclaredFields();
			Annotation[] annotations = clazz.getAnnotations();//获取类的注释
			if (annotations != null) {
				builder.append(CREATE_PRIFX);
				for (Annotation annotation : annotations) {
					if (annotation instanceof AnnonOfClass) {
						AnnonOfClass aoc = (AnnonOfClass)annotation;//转换成具体的注释
						builder.append(wrapperWithAntiQuota(aoc.tableName()))
							.append(Symbol.LEFT_BRACKETS)//添加表名
							.append(Symbol.ENTER);
						//处理每个字段的注释，追加到builder中
						handleField(builder, fields);
						builder.append(Symbol.RIGHT_BRACKETS).append(getSuffix(aoc.desc()))
						.append(Symbol.ENTER).append(Symbol.ENTER);
					}
				}
			}
		}
		return builder.toString();
	}
	
	
	
	/**
	 * 获取创建表的后缀 
	 * @param desc
	 * @return
	 */
	private static String getSuffix(String desc) {
		return SUFFIX.replaceAll("%s", desc);
	}

	/**
	 * 处理每个字段的注释，追加到builder中
	 * @param builder
	 * @param fields
	 */
	private static void handleField(StringBuilder builder, Field[] fields) {
		if (fields != null) {
			for (Field field : fields) {
				if (field.isAnnotationPresent(AnnonOfField.class)) {
					AnnonOfField aof = field.getAnnotation(AnnonOfField.class);
					if (aof != null
							&& aof.inDB()) {
						String fieldName = field.getName();//字段名
						//获取字段的类型
						String fieldType = getFieldType(field.getType().toString());
						String description = aof.desc();//描述
						builder.append(Symbol.TAB);//添加空格
						builder.append(wrapperWithAntiQuota(fieldName)).append(Symbol.BLANK_SPACE);//添加字段名
						builder.append(fieldType).append(Symbol.BLANK_SPACE);//添加字段类型
						builder.append(COMMENT).append(Symbol.BLANK_SPACE);//添加描述关键字
						builder.append(wrapWithQuota(description)).append(Symbol.COMMA).append(Symbol.ENTER);//添加描述
					}
				}
			}
		}
	}

	/**
	 * 根据字段的class类型获取数据库对应的类型 
	 * @param type
	 * @return
	 */
	private static String getFieldType(String type) {
		String strType = CLASS_TABLETYPE_MAP.get(type);
		if (StringUtils.isBlank(strType)) {
			if (type.contains("enums")) {
				strType = "tinyint";
			} else {
				strType = type;
			}
		}
		return strType;
	}

	/**
	 * @Description: 用单引号包裹str
	 * @Author: hzliyong
	 * @Date: 2017年9月14日
	 * @Time: 下午9:43:57
	 * @param str
	 * @return
	 */
	private static String wrapperWithAntiQuota(String str) {
		return wrapWithSymbol(str, Symbol.ANTI_QUOTA);
	}
	
	/**
	 * 用单引号包裹str
	 * @param str
	 * @return
	 */
	private static String wrapWithQuota(String str) {
		return wrapWithSymbol(str, Symbol.QUOTA);
	}
	
	/**
	 * 用symbol包裹str
	 * @param str
	 * @param symbol
	 * @return
	 */
	private static String wrapWithSymbol(String str, String symbol) {
		return symbol + str + symbol;
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
				String name = clazz.getName();
				if (!name.contains("enums")) {//将非枚举类保存到CLASS_LIST中
					CLASS_LIST.add(clazz);
				}
			}
		}
	}
	
	/**
	 * 将create语句保存到文件中
	 */
	private static void saveCreateTableToFile() throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(SAVE_PATH, "rw")) {
			for (Map.Entry<Class<?>, String> entry : CLASS_CREATETABLE_MAP.entrySet()) {
				raf.write(entry.getValue().getBytes());
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		findMetaClassToSet();
		CompileClassLoader cc = new CompileClassLoader();
		try {
			loadClassToList(cc);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Class<?> clazz : CLASS_LIST) {
			CLASS_CREATETABLE_MAP.put(clazz, processToCreate(clazz));
		}
		System.out.println(CLASS_LIST.size());
		saveCreateTableToFile();
		for (Map.Entry<Class<?>, String> entry : CLASS_CREATETABLE_MAP.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
