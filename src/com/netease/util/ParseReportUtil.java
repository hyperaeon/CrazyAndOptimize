package com.netease.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.Bullet;
import org.htmlparser.tags.BulletList;
import org.htmlparser.tags.Span;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.springframework.util.StringUtils;

import com.netease.dto.AllInfoDTO;
import com.netease.dto.BasicInfoDTO;
import com.netease.dto.CheckRecordDTO;
import com.netease.dto.CheckRecordDetailDTO;
import com.netease.dto.LoanDetailDTO;
import com.netease.dto.LoanRecordAbstractDTO;
import com.netease.dto.LoanRecordDTO;
import com.netease.dto.PublicRecordDTO;
import com.netease.enums.AccountType;
import com.netease.enums.CredentialType;
import com.netease.enums.MarriageType;

/**
 * 解析征信报告
 * @author hzliyong
 *
 */
public class ParseReportUtil {

	private static final String ENCODE = "UTF-8";
	
	public static AllInfoDTO all;
	
	public static void init() {
		all = new AllInfoDTO();
		all.setBasicInfoDTO(new BasicInfoDTO());
		all.setCheckRecordDTO(new CheckRecordDTO());
		all.setLoanRecordDTO(new LoanRecordDTO());
		all.setPublicRecordDTO(new PublicRecordDTO());
	}
	
	/**
	 * 打开本地文件
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
				builder.append(content);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	
	/**
	 * 解析个人信用报告入口，主要分为三步骤：
	 * 1、解析所有table标签中的元素，并将这些元素保存到AllInfoDTO类中；
	 * 2、解析不是table标签包围的组件，这些位于信贷记录的信息概要的下方的明细部分。
	 * @param path
	 */
	public static void parseBasic(String content) {
		init();
//		String content = openFile(path);
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			NodeFilter tableFilter = new NodeClassFilter(TableTag.class);
			OrFilter lastFilter = new OrFilter();
			lastFilter.setPredicates(new NodeFilter[]{tableFilter});
			NodeList nodeList = parser.parse(lastFilter);
			List<TableTag> tableTagList = new ArrayList<TableTag>();
			if (nodeList != null) {
				for (int i = 0; i < nodeList.size(); i++) {
					if (nodeList.elementAt(i) instanceof TableTag && i > 0) {//第一个为祖先table，第一个之后都是祖先table的孩子
						TableTag tag = (TableTag)nodeList.elementAt(i);
						tableTagList.add(tag);
					}
				}
			}
			//1、解析所有table
			if (CollectionUtils.isNotEmpty(tableTagList)) {
				for (int i = 0; i < tableTagList.size(); i++) {
					parseTable(tableTagList.get(i), i);
				}
			}
			//2、解析信贷记录中的信用卡、其他贷款等的逾期明细
			parseDetail(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 通过正则表达式解析信贷记录中的信用卡、其他贷款等的逾期明细
	 * 明细分为三种类型：信用卡、购房贷款、其他贷款、为他人担保信，每种类型又有三种明细。
	 * 	信用卡有以下三种：
	 * 	1、发生过逾期的贷记卡账户明细
	 * 	2、从未逾期的贷记卡及透支未超过60天的准贷记卡账户明细
	 * 	3、透支超过60天的准贷记卡账户明细
	 * @param content
	 */
	private static void parseDetail(String content) {
		try {
			Parser parser = Parser.createParser(content, ConstantUtil.CHARSET);
			NodeFilter spanFilter = new NodeClassFilter(Span.class);
			AndFilter andFilter = new AndFilter();
			andFilter.setPredicates(new NodeFilter[]{spanFilter});
			NodeList nodeList = parser.parse(andFilter);
			List<Span> spanList = new ArrayList<Span>();
			if (nodeList != null) {
				for (int i = 0; i < nodeList.size(); i++) {
					Node node = nodeList.elementAt(i);
					if (node instanceof Span) {
						Span span = (Span) node;
						if (ConstantUtil.CLASS_H1.equals(span.getAttribute(ConstantUtil.CLASS))
								|| ConstantUtil.CLASS_SPANEM.equals(span.getAttribute(ConstantUtil.CLASS))) {
							spanList.add(span);
						}
					}
				}
			}
			int[] flagArray = new int[spanList.size()];//记录中只有0和1，对应spanList中的class值，如果为h1则为0，否则为1
			for (int i = 1; i < spanList.size(); i++) {//第一个span为"信息概要"，所有i从1开始
				Span span = spanList.get(i);
				if (ConstantUtil.CLASS_H1.equals(span.getAttribute(ConstantUtil.CLASS))) {
					flagArray[i] = 0;
				} else {
					flagArray[i] = 1;
				}
			}
			int current = 0;//当前指针
			for (int i = 1; i < flagArray.length; i++) {
				/**
				 * 标题为h1，将i存放人current中，h1之后的的class为spanem的内容对应的accountType都为current对应的span文本内容
				 * 如某个标题下有两个明细名称（信用卡有"发生过逾期的贷记卡账户明细",
				 * "从未逾期过的贷记卡及透支未超60天的准贷记卡账户明细"两种。）
				 */
				if (flagArray[i] == 0) {
					current = i;
				} else {
					LoanDetailDTO dto = new LoanDetailDTO();
					String desc = spanList.get(current).getChild(1).getText();
					dto.setAccountType(AccountType.NULL.getEnumByDesc(desc.trim()));
					Span span = spanList.get(i);
					if (span != null) {
						dto.setDetailName(span.getChild(1).getText().replace("如下：", ""));
					}
					all.getLoanRecordDTO().getLoanDetailDTOList().add(dto);
				}
			}
			//解析明细列表
			parseDetaiList(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析明细列表中的内容（标签为ol的网页内容），将其放入all.getLoanRecordDTO().getLoanDetailDTOList()中。
	 * @param content
	 */
	private static void parseDetaiList(String content) {
		try {
			Parser parser = Parser.createParser(content, ConstantUtil.CHARSET);
			NodeFilter nodeFilter = new NodeClassFilter(BulletList.class);//解析<ol>元素
			AndFilter andFilter = new AndFilter();
			andFilter.setPredicates(new NodeFilter[]{nodeFilter});
			NodeList nodeList = parser.parse(andFilter);
			int count = 0;//记录loanDetailDTOList索引
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				if (node instanceof BulletList 
						&& ConstantUtil.CLASS_OL.equals(((BulletList) node).getAttribute(ConstantUtil.CLASS))) {
					NodeList list = node.getChildren();
					if (list != null) {
						List<String> detailList = null;
						for (int j = 0; j < list.size(); j++) {
							Node n = list.elementAt(j);
							if (n instanceof Span && ConstantUtil.CLASS_SPANEM
									.equals(((Span) n).getAttribute(ConstantUtil.CLASS))) {//span的class为spanem，则需要创建新的list。
								detailList = new ArrayList<String>();
								all.getLoanRecordDTO().getLoanDetailDTOList().get(count).setDetailList(detailList);
								count++;
							}
							if (n instanceof Bullet) {//<li>标签
								detailList.add(n.getFirstChild().getText().trim());//存放detailList中的内容
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将table中的内容解析出来
	 * @param content
	 */
	private static void parseTable(TableTag tableTag, int i) {
		String content = "";
		if (tableTag != null) {
			content = tableTag.getChildrenHTML();
		}
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            String textInPage = visitor.getExtractedText();//获取table中的文本
            String[] strArray = null;
            if (!StringUtils.isEmpty(textInPage)) {
            	strArray = textInPage.replaceAll("\\s+", " ").split(" ");
            }
            List<String> elements = new ArrayList<String>();//保存解析后的所有文本内容
            if (strArray != null) {
            	for (String str : strArray) {
            		if (!StringUtils.isEmpty(str)) {
            			elements.add(str.trim());
            		}
            	}
            }
            /**
             * 根据不同的table做不同的解析
             */
            if (i == 0) {//解析基本信息的第一个table
            	buildBasicFirstInfor(elements);
            }
            if (i == 1) {//解析基本信息的第二个table
            	buildBasicSecondInfo(elements);
            }
            if (i == 3) {//解析信贷记录中的 “信息概要”
            	buildLoanInfoAbstract(elements);
            }
            if (i == 7) {//解析公共记录
            	
            }
            if (elements.size() > 0 && 
            		ConstantUtil.ORANIZATION_CHECK.equals(elements.get(0))) {//解析查询记录中的机构查询记录明细， 表的表头内容为“机构查询记录明细”说明是机构查询
            	buildOrganizationCheck(elements);
            }
            if (elements.size() > 0 && 
            		ConstantUtil.PERSONAL_CHECK.equals(elements.get(0))) {//解析查询记录中的个人查询记录明细，表的表头内容为“个人查询记录明细”说明是个人查询
            	buildPersonalCheck(elements);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析查询记录中的个人查询记录明细
	 * @param elements
	 */
	private static void buildPersonalCheck(List<String> elements) {
		if (CollectionUtils.isNotEmpty(elements)) {
			if (StringUtils.isEmpty(elements.get(6))) {//如果编号不存在，则说明不存在查询记录
				return ;
			}
			List<CheckRecordDetailDTO> personalCheckList = all.getCheckRecordDTO()
					.getPersonalCheckList();
			buildCheckDetail(elements, personalCheckList);
		}
	}

	/**
	 * 解析查询记录中的机构查询记录明细
	 * @param elements
	 */
	private static void buildOrganizationCheck(List<String> elements) {
		if (CollectionUtils.isNotEmpty(elements)) {
			if (StringUtils.isEmpty(elements.get(6))) {//如果编号不存在，则说明不存在机构查询记录
				return;
			}
			List<CheckRecordDetailDTO> organizationCheckList = all.getCheckRecordDTO()
					.getOrganizationCheckList();
			buildCheckDetail(elements, organizationCheckList);
		}
	}

	/**
	 * 抽象机构和个人查询明细
	 * @param elements
	 * @param checkList
	 */
	private static void buildCheckDetail(List<String> elements, List<CheckRecordDetailDTO> checkList) {
		for (int i = 0; i < elements.size() - 7; i += 4) {
			CheckRecordDetailDTO checkDetail = new CheckRecordDetailDTO();
			checkDetail.setCheckDate(string2Date(elements.get(i + 7)));
			checkDetail.setCheckOperator(elements.get(i + 8));
			checkDetail.setCheckReason(elements.get(i + 9));
			checkList.add(checkDetail);
		}
	}

	/**
	 * 将字符串的日期转化成Date格式的日期，如“2016年02月02日”转化成“2016-02-02”
	 * @param strDate
	 * @return
	 */
	private static Date string2Date(String strDate) {
		strDate = strDate.replace("年", ConstantUtil.SLASH)
				.replace("月", ConstantUtil.SLASH).replace("日", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 设置基本信息的第一个表格中的内容
	 * @param elements
	 */
	private static void buildBasicFirstInfor(List<String> elements) {
		BasicInfoDTO basic = all.getBasicInfoDTO();
		basic.setReportNumber(elements.get(2));
		basic.setReportTime(convertString2Date(extractDateString(elements.get(3),elements.get(4))));
		basic.setQueryTime(convertString2Date(extractDateString(elements.get(5),elements.get(6))));
	}
	
	/**
	 * 设置基本信息的第二个表格中的内容
	 * @param elements
	 */
	private static void buildBasicSecondInfo(List<String> elements) {
		BasicInfoDTO basic = all.getBasicInfoDTO();
		basic.setName(elements.get(1));
		basic.setCredentialType(CredentialType.IDENTIFICATION);
		String credentialAll = elements.get(3);
		if (credentialAll != null && elements.get(3).split(ConstantUtil.COLON) != null
				&& elements.get(3).split(ConstantUtil.COLON).length == 2) {//elements.get(3)内容是“证件号码：**************1234”，需要去掉“证件号码：”
			basic.setCredentialNumber(elements.get(3).split(ConstantUtil.COLON)[1]);
		}
		basic.setIsMarried(MarriageType.NULL.getIntValueByDesc(elements.get(4)));
	}
	
	/**
	 * 构建信贷记录->信息概要表格
	 * @param elements
	 */
	private static void buildLoanInfoAbstract(List<String> elements) {
		List<LoanRecordAbstractDTO> loanRecordAbstractDTOList = all.getLoanRecordDTO()
				.getLoanRecordAbstractDTOList();
		if (CollectionUtils.isNotEmpty(elements)) {
			for (int i = 0; i < 3; i++) {
				LoanRecordAbstractDTO dto = new LoanRecordAbstractDTO();
				dto.setAccountAmount(Integer.valueOf(elements.get(8 + i)));
				dto.setUnpayedAccount(Integer.valueOf(elements.get(12 + i)));
				dto.setOverdueAccount(Integer.valueOf(elements.get(16 + i)));
				dto.setOverdueNintyAccount(Integer.valueOf(elements.get(20 + i)));
				dto.setWarrantAmount(Integer.valueOf(elements.get(24 + i)));
				dto.setAccountType(AccountType.NULL.getEnumByDesc(elements.get(4 + i)));
				loanRecordAbstractDTOList.add(dto);
			}
		}
	}
	
	/**
	 * str1="查询时间：2016.04.29"
	 * str2 = "21:13:30"
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static String extractDateString(String str1, String str2) {
		StringBuilder builder = new StringBuilder();
		str1 = str1.replaceAll("\\.", "-");
		builder.append(str1.substring(str1.indexOf(ConstantUtil.COLON) + 1).trim());
		builder.append(" ").append(str2);
		return builder.toString();
	}
	
	/**
	 * String类型转换成date
	 * @param time
	 * @return
	 */
	private static Date convertString2Date(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
}
