package com.iu.s1.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankBookservice bankBookservice;
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list() throws Exception {
		System.out.println("list method 실행");
	}

}
