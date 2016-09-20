package com.netease.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

/**
 * 
 * @ClassName: CommonServiceUtil
 * @Description: 征信系统共通服务方法类 
 * @author:JonneyZhang
 * @date: 2016年6月7日 上午11:03:54
 */
public class CommonServiceUtil {
	
	//解决上线jsp页面的c：url里无法传变量的问题
	public static void getBaseURL(HttpServletRequest request,Model model){
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		model.addAttribute("basePath", basePath);
	}
}
