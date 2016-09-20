package com.netease.controller.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.service.SecurityUpgradeService;

/**
 * 
 * @ClassName: SecurityUpgradeController
 * @Description: 新用户在第一次登陆的时候，会提醒需要安全等级升级的提示，该类提供升级相关的服务和页面跳转
 * @author:JonneyZhang
 * @date: 2016年5月25日 下午4:02:20
 */
@Controller
public class SecurityUpgradeController {
	
	final static Logger logger = LoggerFactory.getLogger(SecurityUpgradeController.class);
	@Autowired SecurityUpgradeService securityUpgradeService;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/Credit/security", method = RequestMethod.GET)
	public void getQuestion(HttpServletRequest request, HttpServletResponse response,
			                @RequestParam(value = "loginname") String loginname,
			                @RequestParam(value = "password") String password,
			                @RequestParam(value = "verifyCode") String verifyCode, Model model) throws IOException {
		//时间充足的情况下需要对参数做一些列的基本校验，目前没时间做这个校验工作
		String questionString=null;
		
		try {
			questionString=securityUpgradeService.getQuestionContent(loginname, password, verifyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
