package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {

	@Autowired
	private BankBookservice bankBookservice;
	
	//update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception{
//		System.out.println(bankBookDTO.getBookNumber());
//		System.out.println(bankBookDTO.getBookName());
//		System.out.println(bankBookDTO.getBookRate());
//		System.out.println(bankBookDTO.getBookContents());
//		System.out.println(bankBookDTO.getBookSale());
		int result = bankBookservice.update(bankBookDTO);
		return "redirect:./list";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookservice.detail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// Modelandview
		// 매개변수선언
		// 메서드내에서 객체 생성
		// ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar = bankBookservice.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("bankbook/list");
		return mv;
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookservice.detail(bankBookDTO);
		//디테일.jsp까지 보내서 dto 안에 있는 정보를 하나씩 꺼내서 jsp에 출력
		model.addAttribute("dto", bankBookDTO);
	}
	
	//DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookservice.add(bankBookDTO);
		return "redirect:./list";
	}
	
	//insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add()throws Exception{
	}
	
	//delete
	@RequestMapping("delete")
	public String delete(BankBookDTO bankBookDTO, Model modle ) throws Exception{
		int result = bankBookservice.delete(bankBookDTO);
		// 조회가 성공하면 출력
		// 조회가 실패하면  alert 으로 없는 번호입니다.
		// 다시  list 로 이동
		//common/result.jsp
		
		String view = "common/result";
		
		if(result==0) {
			modle.addAttribute("path", "bankbook/list");
			modle.addAttribute("message", "없는 번호 입니다");
		}else {
			modle.addAttribute("path", "./list");
			modle.addAttribute("message", "삭제되었습니다");
		}
		return view;
		
	}

}
