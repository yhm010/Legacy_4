package com.iu.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankbook.BankBookDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//update (폼용)
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(MemberDTO memberDTO, Model model) throws Exception{
		memberDTO = memberService.mypage(memberDTO);
		model.addAttribute("dto", memberDTO);
	}
	
	//update (db용)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO) throws Exception{
		int result = memberService.update(memberDTO);
		return "redirect:./list";
	}
	
	//mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	
	//logout
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate(); //세션 무효화시킴
		return "redirect:../";
	}
	
	//insert db
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception{
		int result = memberService.join(memberDTO);
		return "redirect:../";
		
	}
	//insert form 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception{
		
	}
	// login 폼 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(value = "remember", defaultValue = "" ,required = false)String remember) throws Exception{
		//model.addAttribute("rememberID", rememberID);
		}
	
	//로그인 실행
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO, String remember, Model model, HttpServletResponse response) throws Exception{
		
		System.out.println("Remember :" + remember);
		if(remember!= null && remember.equals("1")) {
			//cookie 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			//응답
			response.addCookie(cookie);
			//cookie.setPath("/");
			//cookie.setMaxAge(1);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0); //쿠키삭제
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.login(memberDTO);
		
		String path="redirect:./login";
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			path = "redirect:../";
		}
		return path;
	}

}
