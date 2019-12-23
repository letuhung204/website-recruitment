package com.corlogy.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.corlogy.common.CommonUtils;
import com.corlogy.common.StringConstants;
import com.corlogy.model.UserSys;
import com.corlogy.service.UserSysServiceImlp;

@Controller
public class LoginController {
	private UserSys usersys;
	private String errorMsg;
	
	@Autowired
	UserSysServiceImlp userSysService;
	
	@PostConstruct
	public void init() {
		refreshData();
		clearMsg();
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		init();
		session.invalidate();
		model.addAttribute("usersys", usersys);
		model.addAttribute("errorMsg", errorMsg);
		
		return "login";
	}
	
	@RequestMapping(value = { "/onLogin" }, method = RequestMethod.POST)
	public String onLogin(@ModelAttribute("usersys") UserSys usersys, Model model, HttpSession session) {
		if (checkBeforeLogin(usersys.getUserSysName(), usersys.getPassword())) {
			UserSys loginUser = userSysService.findUserSysByUserSysName(usersys.getUserSysName());
			
			if (loginUser != null && CommonUtils.mapHashBCrypt(usersys.getPassword(), loginUser.getPassword())) {
				session.setAttribute("username", loginUser.getUserSysName());
				
				return "redirect:/admin";
			} else {
				errorMsg = StringConstants.login_error_msg;
			}
		}
		
		model.addAttribute("usersys", usersys);
		model.addAttribute("errorMsg", errorMsg);
		
		return "login";
		
	}
	
	public boolean checkBeforeLogin(String username, String password) {
		if (username == null || username.trim().length() == 0) {
			errorMsg = StringConstants.login_error_username_empty;
			return false;
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg = StringConstants.login_error_password_empty;
			return false;
		}
		
		return true;
	}
	
	public void refreshData() {
		usersys = new UserSys();
	}
	
	public void clearMsg() {
		errorMsg = "";
	}
}
