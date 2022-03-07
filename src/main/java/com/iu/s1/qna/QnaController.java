package com.iu.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		List<QnaDTO> ar = qnaService.list(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/add");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.add(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaDTO = qnaService.detail(qnaDTO);
		mv.addObject("qna", qnaDTO);
		mv.setViewName("qna/detail");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(QnaDTO qnaDTO, Model model)throws Exception{
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("qna", qnaDTO);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO)throws Exception{
		System.out.println(qnaDTO.getContents());
		System.out.println(qnaDTO.getNum());
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}

}
