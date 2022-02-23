package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		return mv;
	}

	// detail
	@RequestMapping(value = "deteil", method = RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.deteil(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/deteil");
		return mv;
	}

	// DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.add(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

	// insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/add");
		return mv;
	}

	// update 폼으로 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.deteil(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}

	// DB에 update 처리
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		System.out.println(noticeDTO.getContents());
		System.out.println(noticeDTO.getNum());
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";
	}

}
