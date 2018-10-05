package com.yjp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.springboot.bean.User;
import com.yjp.springboot.server.UserService;

@RestController
public class Restcontroller {
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	@Transactional(rollbackFor=Exception.class)
	public String test(){
		User user = new User();
		user.setId(1);
		user.setName("张三");
		user.setEmail("lisi@163.com");
		userService.save(user);
		User user1 = new User();
		user1.setId(1);
		user1.setName("李四的课看到呢的魅力麻烦啦免得浪费啦i恩的看法里面的弗莱厄的魅力发欸门打开了发了拉欸骄傲费德勒麦当劳发了暗恋我曼德拉了啊了");
		user1.setEmail("lisi@163.com");
		userService.save(user1);
		return content;
	}

}
