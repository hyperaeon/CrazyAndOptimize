package com.netease.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.lexer.PageAttribute;
import org.htmlparser.tags.Bullet;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.ParagraphTag;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;
import org.springframework.util.StringUtils;

/**
 * 解析登录、获取报告及注册流程中的页面
 * @author ly
 *
 */
public class ParsePageUtil {

	private static final String ENCODE = "UTF-8";
	
	private static final String PATH = "E:/temp/applyCreditInfoPage-unapplied.html";
			
	public static void main(String[] args) {
//		Map<String, String> map = parseInput("aaa");
//		if (map != null) {
//			for (Map.Entry<String, String> entrySet : map.entrySet()) {
//				System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
//			}
//		}
		
		//解析error_field
//		System.out.println(parseErrorField(openFile(PATH)));
//		System.out.println(parseLoginResponse(openFile(PATH)));
//		System.out.println(parseMessage(openFile(PATH)));
//		System.out.println(parseMessage(openFileAll(PATH)));
		/**
		 * 解析问题页面
		 */
//		String questionPage = openFile(PATH);
//		Map<String, List<String>> map = extractQuestion(questionPage);
//		for (Map.Entry<String, List<String>> m : map.entrySet()) {
//			System.out.println(m.getKey());
//			List<String> list = m.getValue();
//			for (String s : list) {
//				System.out.print(s + "\t");
//			}
//			System.out.println();
//		}
//		
//		Map<String, String> map2 = parseInput(questionPage);
//		for (Map.Entry<String, String> m : map2.entrySet()) {
//			System.out.println(m.getKey() + m.getValue());
//		}
		/**
		 * 解析提交问题页面后的响应页面
		 */
//		String responsePage = openFile(PATH);
//		System.out.println(extractResponseAfterSubmitQuestion(responsePage));
		/**
		 * 解析“获取信用信息”页面
		 */
//		String responsePage = openFile(PATH);
//		parseRedioType(responsePage);
		
		/**
		 * 解析信息服务 > 申请信用信息页面
		 */
//		String responsePage = openFile(PATH);
//		System.out.println(parseReportStatus(responsePage));
	}
	
	/**
	 * 解析html中的input属性，将name和value放到map中
	 * @param regPage
	 * @return
	 */
	public static Map<String, String> parseInput(String regPage) {
		if (StringUtils.isEmpty(regPage)) {
			return null;
		}
		Map<String, String> nameValue = null;
		NodeList nodeList = parseTag(regPage, InputTag.class);
		List<InputTag> inputTagList = new ArrayList<InputTag>();
		nameValue = new HashMap<String, String>();
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.elementAt(i) instanceof InputTag) {
				InputTag inputTag = (InputTag) nodeList.elementAt(i);
				inputTagList.add(inputTag);
				Vector<PageAttribute> vector = inputTag.getAttributesEx();
				buildNameValueMap(vector, nameValue);
			}
		}
		return nameValue;
	}
	
	/**
	 * 解析“获取信用信息”页面，将radio_type为disabled的value进行拼接，如果为“252421”，则表示未提交申请或者刚提交申请，
	 * 至于是没提交申请还是刚提交申请还需要根据本页面中的message值判断：如果为“暂无信息”则表示未提交申请；
	 * 如果是“您的信用信息查询请求已提交，请在24小时后访问平台获取结果。为保障您的信息安全，您申请的信用信息将于7日后自动清理，
	 * 请及时获取查询结果。”则表示刚提交申请。
	 * @param responsePage
	 * @return
	 */
	public static String parseRedioType(String responsePage) {
		if (StringUtils.isEmpty(responsePage)) {
			return "";
		}
		NodeList nodeList = parseTag(responsePage, InputTag.class);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.elementAt(i);
			if (node instanceof InputTag) {
				InputTag inputTag = (InputTag) node;
				if (ConstantUtil.REDIO_TYPE.equals(inputTag.getAttribute(ConstantUtil.CLASS))
						&& inputTag.getText().contains("disabled")) {//class为“radio_type”，并且为disabled的input
					builder.append(inputTag.getAttribute(ConstantUtil.VALUE));
				}
			}
		}
		System.out.println(builder.toString());
		return builder.toString();
	}
	/**
	 * 从页面中解析_error_field_元素，如“<span id="_error_field_">您已注册过用户，请返回首页直接登录。</>”
	 * 返回错误信息，如果没有错误则返回空字符串
	 * @param errorPage
	 * @return
	 */
	public static String parseErrorField(String errorPage) {
		NodeList nodeList = parseTag(errorPage, Span.class);
		String result = "";
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				if (node instanceof Span) {
					Span span = (Span) node;
					NodeList child = span.getChildren();
					if (child != null) {//如果有错误信息，则会有两层span
						if (child.elementAt(0) instanceof Span) {
							span = (Span) child.elementAt(0);
							if (ConstantUtil.ERROR_FILED.equals(span.getAttribute("id"))) {
								result = span.toPlainTextString();
								if (!StringUtils.isEmpty(result)) {//有错误信息，则直接返回
									return result;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 解析登录响应结果页面，如果有错误信息，则会有两种结果：
	 * 	1、“<span id="_@MSG@_" class="p4">验证码输入错误,请重新输入<br/>”
	 *  2、“<span id="_error_field_">登录名或密码错误！</>”
	 * @param page
	 * @return
	 */
	public static String parseLoginResponse(String page) {
		NodeList nodeList = parseTag(page, Span.class);
		String result = "";
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				if (node instanceof Span) {
					Span span = (Span)node;
					NodeList subNodeList = span.getChildren();
					if (subNodeList != null) {
						for (int j = 0; j < subNodeList.size(); j++) {
							Node subNode = subNodeList.elementAt(j);
							if (subNode instanceof Span) {
								Span subSpan = (Span)subNode;
								if (ConstantUtil.ERROR_FILED.equals(subSpan.getAttribute("id"))
										|| ConstantUtil.LOGIN_ERROR_MSG_ID.equals(subSpan.getAttribute("id"))) {
									result = subSpan.toPlainTextString();
									if (!StringUtils.isEmpty(result)) {//有错误信息，则直接返回
										return result;
									}
								}
							}
							
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 解析不同的标签，返回nodeList
	 * @param page
	 * @return
	 */
	private static NodeList parseTag(String page, Class<?> clazz) {
		NodeList nodeList = null;
		try {
			Parser parser = Parser.createParser(page, ConstantUtil.CHARSET);
			NodeFilter spanFilter = new NodeClassFilter(clazz);
			AndFilter andFilter = new AndFilter();
			andFilter.setPredicates(new NodeFilter[]{spanFilter});
			nodeList = parser.parse(andFilter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodeList;
	}
	
	/**
	 * 解析获取报告时出现的$("#messages").text()内容，
	 * 或者解析alert("由于您长时间未进行任何操作，系统已退出，如需继续使用请您重新登录。");
	 * @param messagePage
	 * @return
	 */
	public static String parseMessage(String messagePage) {
		String[] lines = messagePage.split("\n");
		String reg = "#messages";
		List<String> messageList = new ArrayList<String>();
		for (String line : lines) {
			if (line.contains(reg)) {
				messageList.add(line);
			} else if (line.contains(ConstantUtil.RELOGIN)) {
				return ConstantUtil.RELOGIN;
			}
		}
		String result = "";
		if (messageList.size() > 0) {
			String message = messageList.get(messageList.size() - 1).trim();
			result = message.substring(21, message.length() - 3);
		}
		System.out.println(result);
		return result;
	}
	
	/**
	 * 从回答问题页面中解析问题、选项使用map封装，其中的map的key保存问题，value使用list保存问题对应的选项
	 * @param questionPage
	 * @return
	 */
	public static Map<String, List<String>> extractQuestion(String questionPage) {
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		NodeList nodeList = parseTag(questionPage, Bullet.class);
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				if (node instanceof Bullet) {
					NodeList subNodeList = node.getChildren();//包含一个问题及问题对应的选项
					if (subNodeList != null) {
						int count = 0;
						String currentKey = "";
						for (int j = 0; j < subNodeList.size(); j++) {
							Node subNode = subNodeList.elementAt(j);subNode.getLastChild();//包含<p>及其下级元素
							if (subNode instanceof ParagraphTag) {
								NodeList tripleList = subNode.getChildren();//包含<span>元素，<span>元素包括问题和选项
								if (tripleList != null) {
									for (int k = 0; k < tripleList.size(); k++) {
										Node tripleNode = tripleList.elementAt(k);
										if (tripleNode instanceof Span) {
											if (count == 0) {
												String content = ((Span)tripleNode).getChildrenHTML();
												currentKey = content.substring(content.indexOf(ConstantUtil.COLON) + 1);
												map.put(currentKey, new ArrayList<String>());
											} else {
												List<String> list = map.get(currentKey);
												list.add(((Span)tripleNode).getChildrenHTML());
											}
											count++;
										}
									}
								}
							}
						}
					}
					
				}
			}
		}
		return map;
	}
	
	
	/**
	 * 提取提交回答问题页面后返回的响应页面
	 * @param responsePage
	 * @return
	 */
	public static String extractResponseAfterSubmitQuestion(String responsePage) {
		String result = "";
		try {
			Parser parser = Parser.createParser(responsePage, ConstantUtil.CHARSET);
			NodeFilter nodeFilter = new NodeClassFilter(Div.class);
			AndFilter andFilter = new AndFilter();			
			andFilter.setPredicates(new NodeFilter[]{nodeFilter});
			NodeList nodeList = parser.parse(andFilter);
			if (nodeList != null) {
				for (int i = 0; i < nodeList.size(); i++) {
					Node node = nodeList.elementAt(i);
					if (node instanceof Div) {
						String className = ((Div) node).getAttribute(ConstantUtil.CLASS);
						if (ConstantUtil.TABLE_MID_BK.equals(className)) {
							result = node.toPlainTextString();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}
	
	/**
	 * 解析是否包含notice_div1，其内容为“您的个人信用信息产品已存在，请点击"获取信用信息"查看。
	 * 若继续申请查询，现有的个人信用信息产品将不再保留，是否继续？”
	 * @param page
	 * @return
	 */
	public static String parseDivMessage(String page) {
		NodeList nodeList = parseTag(page, Div.class);
		String result = "";
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				if (node instanceof Div) {
					Div div = (Div) node;
					if (ConstantUtil.NOTICE_DIV1.equals(div.getAttribute(ConstantUtil.CLASS))) {
						result = div.toPlainTextString().trim();
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 解析身份验证码出错时的页面
	 * @param apge
	 * @return
	 */
	public static String parseCredentialCodeErrorPage(String page) {
		String result = "";
		NodeList nodeList = parseTag(page, Span.class);
		if (nodeList != null) {
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = (Node) nodeList.elementAt(i);
				if (node instanceof Span) {
					Span span = (Span) node;
					if (ConstantUtil.CLASS_ERRO_DIV1.equals(span.getAttribute(ConstantUtil.CLASS))) {
						result = span.toPlainTextString().trim();
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 解析信息服务 > 申请信用信息页面，获取报告的状态
	 * @param page
	 * @return
	 */
	public static String parseReportStatus(String page) {
		String result = "";
		if (StringUtils.isEmpty(page)) {
			return result;
		}
		String[] lines = page.split("\n");
		for (String line : lines) {
			if (line.contains(ConstantUtil.CLASS_REPORT_STATUS_FONT) 
					&& line.indexOf("(") > 0) {
				result = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
			}
		}
		return result;
	}
	/**
	 * 从vector中获取name和value的对应值
	 * @param nameValue
	 */
	private static void buildNameValueMap(Vector<PageAttribute> vector, Map<String, String> nameValue) {
		String nameText = "";
		String valueText = "";
		if (CollectionUtils.isNotEmpty(vector)) {
			for (PageAttribute pageAttribute : vector) {
				String attributeName = pageAttribute.getName();
				String attributeValue = pageAttribute.getValue();
				if (attributeName != null) {
					if (attributeName.contains("name")) {
						nameText = attributeValue;
					}
					if (attributeName.contains("value")) {
						valueText = attributeValue;
					}
				}
			}
		}
		nameValue.put(nameText, valueText);
	}
	
	/**
	 * 打开本地文件，一行一行的读取文件
	 * @param fileName
	 * @return
	 */
	private static String openFile(String fileName) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(fileName)), ENCODE));
			String content = "";
			while ((content = br.readLine()) != null) {
				builder.append(content + "\n");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	/**
	 * 打开本地文件，整个文件读取
	 * @param fileName
	 * @return
	 */
	private static String openFileAll(String fileName) {
		File file = new File(fileName);
		Long fileLength = file.length();
		byte[] fileContent = new byte[fileLength.intValue()];
		String resultContent = "";
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(fileContent);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			resultContent = new String(fileContent, ConstantUtil.CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultContent;
	}
}
