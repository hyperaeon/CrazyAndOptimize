package com.ip.service;

import org.apache.commons.lang.StringUtils;

import com.credit.http.HttpUtils;
import com.ip.constant.Constants;
import com.ip.dto.SinaIpDTO;
import com.util.JsonUtils;
import com.util.RandomUtils;

public class IpAnalyseService {

	public static SinaIpDTO getSinaIpDTOByIp(String ip) {
		String result = null;
		try {
			result = HttpUtils.httpGet(Constants.SINA_IP + ip);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		SinaIpDTO dto = null;
		if (StringUtils.isNotBlank(result)) {
			try {
				dto = JsonUtils.fromJson(result, SinaIpDTO.class);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return dto;
	}
	
	public static void main(String[] args) {
//		String ip = "218.192.3.42";
		for (int i = 0; i < 10000; i++) {
			String ip = RandomUtils.getRandomIp(Constants.IP_MAX);
			SinaIpDTO dto = getSinaIpDTOByIp(ip);
			System.out.println(i + " " + ip + " " + dto);
		}
	}
}
