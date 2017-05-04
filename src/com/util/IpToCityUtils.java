package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.ip.dto.IpCityBean;

/**
 * 功能ip解析
 * 输入clientIp
 * Created by hzluyufeng on 2017/5/3.
 */
//public class IpToCity extends UDF
public class IpToCityUtils  {
    private static TreeMap<Long,IpCityBean> ipMap= new TreeMap<Long,IpCityBean>();
    
    private static File ipFile;
    
    private static final  String SEPARATOR ="\t";
    
    //初始化ip城市维表，并存入缓存
    static {
        System.out.println("---------init-------------");
        if(null == ipMap){
            ipMap =new TreeMap<Long,IpCityBean>();//判断容器map是否为null，否则进行实例化
        }
    }
    /*
    ip城市维表缓存本地
    */
	public static void load(String filename) throws IOException {
		ipFile = new File(filename);
		FileInputStream fin = null;
		BufferedReader reader;
		String line;
		try {
			fin = new FileInputStream(ipFile);
			reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
			while ((line = reader.readLine()) != null) {
				String[] cols = line.split(SEPARATOR, -1);
				if (cols.length != 15) {
					continue;
				}
				if (cols[0]
						.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")
						&& cols[1]
								.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")) {
					long ipstartlong = ipToLong(cols[0]);
					long ipendlong = ipToLong(cols[1]);
					ipMap.put(ipstartlong, new IpCityBean(ipstartlong, ipendlong, cols[4], cols[5], cols[6], cols[7],
							cols[8], cols[9], cols[10], cols[11], cols[12], cols[13], cols[14]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /*
    * 功能描述
    *  将ip转换为long类型
    *  clientIp
    * */
    private static long ipToLong(String clientIp){
        return Long.parseLong(clientIp.split("\\.")[0]
                + StringUtils.leftPad(clientIp.split("\\.")[1],3,"0")
                + StringUtils.leftPad(clientIp.split("\\.")[2],3,"0")
                + StringUtils.leftPad(clientIp.split("\\.")[3],3,"0")
        );
    }
    /*
    * 功能描述
    * 根据ip返回对应的城市信息、大区、省份、城市、国家
    * clientIp
    * */
    public static IpCityBean evalute(String clientIp){
    	IpCityBean cityInfo = null;
        if(StringUtils.isNotBlank(clientIp) && clientIp.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")){
            long clientIpLong = ipToLong(clientIp);
            Map.Entry<Long,IpCityBean> tmpMap=ipMap.floorEntry(clientIpLong);
            if(null!= tmpMap) {
				cityInfo = tmpMap.getValue();
            }
        }
        return cityInfo;
    }
    
    /*
    * test
    * */
    public static void main(String args[]) throws Exception {
        String filename = "C:/Users/hzliyong/git/CrazyAndOptimize/doc/ip_conf.txt";
        IpToCityUtils.load(filename);
        IpCityBean bean = IpToCityUtils.evalute("123.58.160.131");
        System.out.println(bean);
    }
}
