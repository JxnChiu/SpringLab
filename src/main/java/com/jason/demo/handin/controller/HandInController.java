package com.jason.demo.handin.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jason.demo.handin.model.HandInRequest;
import com.jason.demo.handin.model.HandInResponse;

@RestController
public class HandInController {
	
	@RequestMapping(path = "/handin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HandInResponse handInRes(@RequestBody HandInRequest handInReq) {
		
		HandInResponse res = new HandInResponse();
		
		res.setReturnCode(9999);
		
		res.setTimestamp(System.currentTimeMillis());
		res.setReturnCode(0);
		res.setReturnMessage("You are passed!");
		res.setEmail(handInReq.getEmail());
		res.setEmpoleeId(handInReq.getEmpoleeId());
		res.setMode("Spring Boot + Spring REST");
		
		return res;
	};
	
//	/client-rest/biteMe
	
}
