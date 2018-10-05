package com.yjp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjp.springboot.bean.User;

@Controller
public class jspcontroller {
	
	@RequestMapping("/test1")
	public String test(User user){
//		m.addAttribute("now", new Date());
		System.out.println(user.getName());
		return "index";
	}

}
