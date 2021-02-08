package com.jason.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.jason.demo.dao.UserDao;
import com.jason.demo.entity.User;

@RestController
@RequestMapping("/")
public class JasonDemoController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/XXX")
	public ModelAndView restredirect(){  
//		return new ModelAndView("/hey/theFirstPage.jsp");
		return new ModelAndView("/hey/NewFile.html");
	}
	
	@RequestMapping("/OOO")
	public String stringForward(){  
		return "/hey/theFirstPage.jsp";
	}
	
	@RequestMapping("/YYY")
	public String stringRedirect(){  
		return "redirect:/hey/theFirstPage.jsp";
	}


	@RequestMapping("/")
	public String noEndPoint() {
		return "Hello,World!";
	}

	
	@RequestMapping("/save")
	public void returnJSON() {
		User entity = new User();
		entity.setName("first");
		entity.setEmail("first@fist");
		entity.setPassword("first_password");
		
		userDao.save(entity);
	}
	
//	@Value("${com.jj.name}")
//    private String name;
//
//    @Value("${com.jj.want}")
//    private String want;
//
//    @Value("${com.jj.sentence}")
//    private String sentence;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
//        return name + "," + want;
//    }
//
//    @RequestMapping(value = "/sentence", method = RequestMethod.GET)
//    public String sentence() {
//        return sentence;
//    }
}
