package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s1.bankbook.BankBookDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//insert db
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception{
		int result = memberService.join(memberDTO);
		return "redirect:../";
		
	}
	//insert form
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception{
	}
	
	// login 폼 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() throws Exception{
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO) throws Exception{
		memberDTO = memberService.login(memberDTO);
		
		String path="redirect:./login";
		
		if(memberDTO != null) {
			path = "redirect:../";
		}
		return path;
	}

}
