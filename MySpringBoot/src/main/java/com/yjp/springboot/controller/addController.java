package com.yjp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjp.springboot.bean.User;

@Controller
public class addController {
	
	@RequestMapping("/add")
	public String test(){
		return "add";
	}

}
