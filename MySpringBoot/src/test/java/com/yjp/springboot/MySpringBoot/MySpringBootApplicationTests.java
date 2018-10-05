package com.yjp.springboot.MySpringBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yjp.springboot.bean.User;
import com.yjp.springboot.server.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//@WebAppConfiguration二选一
@EnableTransactionManagement
public class MySpringBootApplicationTests {
	
	@Autowired
	private MockMvc  mvc;
	
	@Autowired
	private UserService userService;

	@Test
	@Transactional(rollbackFor=Exception.class,propagation = Propagation.REQUIRED)
	public void contextLoads() {
		try {
//			User user = new User();
//			user.setId(1);
//			user.setName("李四");
//			user.setEmail("lisi@163.com");
//			userService.save(user);
//			User user1 = new User();
//			user1.setId(1);
//			user1.setName("李四的课看到呢的魅力麻烦啦免得浪费啦i恩的看法里面的弗莱厄的魅力发欸门打开了发了拉欸骄傲费德勒麦当劳发了暗恋我曼德拉了啊了");
//			user1.setEmail("lisi@163.com");
//			userService.save(user1);
			
			User user=userService.findById(1);
			System.out.println(user.getId()+"  "+user.getName());
			
			mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
			
//			User user = new User();
//			ObjectMapper mapper =  new ObjectMapper();
//			mvc.perform(MockMvcRequestBuilders.post("").contentType(MediaType.APPLICATION_JSON_UTF8)
//					.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
