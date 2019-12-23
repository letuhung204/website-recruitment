package com.corlogy.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.corlogy.common.StringConstants;
import com.corlogy.model.UserSys;
import com.corlogy.model.UserSysError;
import com.corlogy.service.UserSysServiceImlp;

@Controller
@RequestMapping("/usersys")
public class UserSysController {
	private List<UserSys> usersyss;
	private UserSys usersys;
	private String successMsgTable;
	private String errorMsgTable;
	private UserSysError userSysErr;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSysController.class);

	@Autowired
	UserSysServiceImlp userSysService;

	@PostConstruct
	public void init() {
		refreshMsg();
		clearData();
	}

	@RequestMapping(value = { "/listUserSys" }, method = RequestMethod.GET)
	public String getListAllUserSys(Model model, HttpSession session) {
		try {
			usersyss = userSysService.findAllUserSys();
			model.addAttribute("usersyss", usersyss);
			model.addAttribute("usersys", usersys);
			model.addAttribute("successMsgTable", successMsgTable);
			model.addAttribute("userSysErr", userSysErr);
			model.addAttribute("errorMsgTable", errorMsgTable);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return "usersys";
	}
	
	@RequestMapping(value = { "/addUserSys" }, method = RequestMethod.POST)
	public String addUserSys(@ModelAttribute("usersys") UserSys usersys, Model model) {
		refreshMsg();
		try {
			usersys.setUserSysId(userSysService.getMaxUserSysId() + 1);

			if (isValidUserSys(usersys) && userSysService.addNewUserSys(usersys)) {
				successMsgTable = StringConstants.user_success_add_msg;
			} else {
				errorMsgTable = StringConstants.user_error_add_msg;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return "redirect:listUserSys";
	}
	
	public boolean isValidUserSys(UserSys userSys) {

		return true;
	}
	
	public void refreshMsg() {
		successMsgTable = "";
		errorMsgTable = "";
		userSysErr = new UserSysError();
	}
	
	public void clearData() {
		usersys = new UserSys();
	}
}
