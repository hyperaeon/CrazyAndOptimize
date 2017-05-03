package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {

	private static ObjectMapper defaultMapper;

	private static ObjectMapper objectMapper;
	
	static{
		defaultMapper=new ObjectMapper();
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static String toPrettyJson(Object value){
		try {
			ObjectWriter writerWithDefaultPrettyPrinter = defaultMapper.writerWithDefaultPrettyPrinter();
			return writerWithDefaultPrettyPrinter.writeValueAsString(value);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static JsonObject getMap(String key,Object value){
		JsonObject map=new JsonObject();
		map.put(key, value);
		return map;
	}

	public static <T> T fromJson(String json,Class<T> clazz){
		if(StringUtils.isBlank(json)){
			return null;
		}
		try {
			return defaultMapper.readValue(json, clazz);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ObjectMapper getJsonMapper() {
		return objectMapper;
	}
	
	public static <T> T readObject(String json, Class<T> clz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		try {
			return getJsonMapper().readValue(json, clz);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * json转化成复杂的类型
	 * @param json
	 * @param clazz
	 * @return
	 * hzliyong
	 */
	public static <T> T fromStrToObject(String json, Class<T> clazz) {
		if(StringUtils.isBlank(json)){
			return null;
		}
		try {
			JSONObject jsonObject = JSONObject.fromObject(json);
			return (T) JSONObject.toBean(jsonObject, clazz);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 转化成复杂的对象，如果对象包含自定义的类或者list等，需要在classMap中声明
	 * @param json
	 * @param clazz
	 * @param classMap
	 * @return
	 * hzliyong
	 */
	public static <T> T fromStrToObject(String json, Class<T> clazz, Map<String, Class> classMap) {
		if(StringUtils.isBlank(json)){
			return null;
		}
		try {
			JSONObject jsonObject = JSONObject.fromObject(json);
			return (T) JSONObject.toBean(jsonObject, clazz, classMap);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static <T> T fromJson(String json,TypeReference<T> typeReference){
		if(StringUtils.isBlank(json)){
			return null;
		}
		try {
			return defaultMapper.readValue(json, typeReference);
		} catch (Exception e) {
			return null;
		}
	}
	public static JsonNode fromJson(String json){
		if(StringUtils.isBlank(json)){
			return null;
		}
		try {
			return defaultMapper.readTree(json);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String toJson(Object value){
		try {
			return defaultMapper.writeValueAsString(value);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static class JsonObject extends HashMap<String,Object>{
		private static final long serialVersionUID = 8297011562613523515L;

		@SuppressWarnings("unchecked")
		public <T> T get(String property,Class<?> clazz){
			Object value=this.get(property);
			if(value!=null){
				if (clazz == Long.class) {
					return (T) Long.valueOf(value.toString());
				} else if (clazz == Integer.class) {
					return (T) Integer.valueOf(value.toString());
				} else if (clazz == Float.class) {
					return (T) Float.valueOf(value.toString());
				} else if (clazz == Double.class) {
					return (T) Double.valueOf(value.toString());
				} else {
					return (T) clazz.cast(value);
				}
			}
			return null;
		}

		public String toJson(){
			return JsonUtils.toJson(this);
		}
	}
	public static void main(String[] args) {
		Object obj=null;
		System.out.println(obj);
		obj=fromJson("null", Object.class);
		System.out.println(obj);
		String json = toJson(null);
		System.out.println(json);
		
		List<String> list = new ArrayList<String>();
		list.add("pre1");
		list.add("pre2");
		System.out.println(JsonUtils.toJson(list));
	}
}
