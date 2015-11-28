package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ToDateAppend {

	private static final String PATTERN = "\\s{1}'\\d{4}-\\d{1,}-\\d{1,} \\d{1,}:\\d{1,}:\\d{1,}'";
	
	private static final String SOURCE_PATH = "E:\\Doc\\Data_ana\\DDB\\";
	
	private static final String DESTIN_PATH = "E:\\Doc\\Data_ana\\DDB\\handled\\";
	
	private static final String[] files = {
//		"TB_ItemCenter_Category.sql"
//		,"TB_ItemCenter_PoProduct.sql"
//		,"TB_ItemCenter_PoSku.sql"
//		,"TB_Order_OrderPackage.sql"
//		,"TB_Order_OrderSku.sql"
//		,"TB_Order_ReturnOrderSku.sql"
//		,"TB_Order_ReturnOrderSku_New.sql"
//		,"TB_SaleSchedule_Brand.sql"
//		,"TB_ShopCenter_PlatformServiceFee.sql"
//		,"TB_ShopCenter_Shop.sql"
//		,"TB_SaleSchedule_Schedule.sql"
		"TB_Order_OrderForm11-10.sql"
	};
	
	public static void main(String[] args) {
		try{
			BufferedReader br = null;
			BufferedWriter bw = null;
			for (String file : files) {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(SOURCE_PATH + file)));
				String buffer = null;
				StringBuilder sb = new StringBuilder();
				while ((buffer = br.readLine()) != null) {
					sb.append(handle(buffer)).append("\r\n");
				}
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DESTIN_PATH + file)));
				bw.write(sb.toString());
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	private static String handle(String buffer) {
		String test = "INSERT INTO TB_Order_ReturnOrderSku VALUES (1158, 1406, 169.00, 1, '', " + 
			"1419211942250, '', 0, '其它', 3, 1, 1001, 169.00, 2110, 4115, '2014-12-22 09:32:22', '2014-12-22 16:10:01');";
		String[] seg = buffer.split(",|\\)");//根据逗号或者右括号分组
		StringBuilder sb = new StringBuilder();
		for (String s : seg) {
			s = s.replaceAll("\\\\'", "");
			if (s.matches(PATTERN)) {
				sb.append(",to_date(").append(s).append(", 'yyyy-mm-dd hh24:mi:ss')");
			} else {
				sb.append("," + s);
			}
		}
		String result = sb.toString().replaceFirst(",", "").replaceFirst(",;", ");");
		return result;
	}
}
