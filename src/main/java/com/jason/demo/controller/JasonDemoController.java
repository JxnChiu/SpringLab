package com.jason.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jason.demo.dao.UserDao;
import com.jason.demo.entity.UserEntity;
import com.jason.demo.service.UserService;

//@RestController
@Controller
@RequestMapping("/")
public class JasonDemoController {
	private final static Logger logger = LogManager.getLogger();

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userSvc;

	
	
	
	
	@RequestMapping("/XXX")
	public ModelAndView restredirect() {
//		return new ModelAndView("/hey/theFirstPage.jsp");
		logger.debug("XXX is working");
		return new ModelAndView("/hey/NewFile.html");
	}

	@RequestMapping("/OOO")
	public String stringForward() {
		return "/hey/theFirstPage.jsp";
	}

	@RequestMapping("/YYY")
	public String stringRedirect() {
		return "redirect:/hey/theFirstPage.jsp";
	}

	@RequestMapping("/")
	public String noEndPoint() {
		return "Hello,World!";
	}

	@RequestMapping("/save")
	public void returnJSON() {

		UserEntity entity = new UserEntity();
		entity.setAccount("first");
		entity.setMema("memala");
		entity.setEmail("jason@joHoChio.com");
//		entity.setIsDelete(false);

		userDao.save(entity);
		System.out.println("\n這裡\n");
		return;
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
